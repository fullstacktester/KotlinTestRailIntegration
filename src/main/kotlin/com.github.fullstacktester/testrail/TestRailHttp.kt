package com.github.fullstacktester.testrail

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.HttpException
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.fuel.util.encodeBase64ToString
import java.net.InetSocketAddress
import java.net.Proxy
import com.github.kittinunf.result.Result as FuelResult

class TestRailHttp {

    companion object {
        fun execute(testRailRequest: TestRailRequest) : String {

            val config = TestRailConfig().config

            FuelManager.instance.basePath = config.getFullPath().toString()
            setProxyIfRequired(config)
            setHeaders(config)

            return sendRequest(testRailRequest)
        }

        private fun sendRequest(testRailRequest : TestRailRequest) : String {
            val (_, response, result) = when {
                testRailRequest.method == "GET" -> Fuel.get(testRailRequest.path)
                testRailRequest.method =="POST"
                        && testRailRequest.jsonBody.isNullOrEmpty() -> Fuel.post(testRailRequest.path)
                testRailRequest.method =="POST"
                        && !testRailRequest.jsonBody.isNullOrEmpty() -> Fuel.post(testRailRequest.path).body(testRailRequest.jsonBody)
                else -> throw Exception("Unknown request type: ${testRailRequest.method}")
            }.responseJson()

            return when (result) {
                is FuelResult.Success -> result.get().content

                else -> (throw HttpException(response.statusCode, response.data.decodeToString()))
            }
        }

        private fun setHeaders(config : TestRail) {
            FuelManager.instance.baseHeaders = mapOf(
                basicAuthHeader(config.username, config.password),
                "Content-Type" to "application/json"
            )
        }

        private fun basicAuthHeader(username : String, password : String) : Pair<String, String> {
            val auth = "$username:$password"
            val encodedAuth = auth.encodeBase64ToString()
            return "Authorization" to "Basic $encodedAuth"
        }

        private fun setProxyIfRequired(config : TestRail) {
            if (config.proxyEnabled) {
                val addr = InetSocketAddress(config.proxyHostname, config.proxyPort!!)

                FuelManager.instance.proxy = Proxy(Proxy.Type.SOCKS, addr)
            }
        }
    }
}