package com.github.fullstacktester.testrail

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import io.github.config4k.extract
import java.net.URL

class TestRailConfig
{
    val config : TestRail = conf.extract("config.testrail")

    companion object {
        val conf : Config = ConfigFactory.load().resolve()
    }

    init {
        config.safePrint()
    }

}

data class TestRail (
    val baseApiUrl: String,
    val baseApiPath: String = "index.php?/api/v2/",
    val username: String,
    val password: String,
    val projectId: Int,
    val suiteId: Int,
    val runTitle: String?,
    val runDescription: String?,
    val proxyEnabled: Boolean = false,
    val proxyHostname: String? = null,
    val proxyPort: Int? = null
) {
    init {
        require(!baseApiUrl.containsWhitespace()) { "baseApiUrl must not contain whitespace" }
        require(!baseApiPath.containsWhitespace()) { "baseApiPath must not contain whitespace" }

        if (proxyEnabled) {
            require(!proxyHostname.isNullOrEmpty()) { "if proxy is enabled, proxyHostName must have a value" }
            require(proxyPort != null && proxyPort > 0) { "if proxy is enabled, proxyPort must have a value" }
        }
    }

    private fun String.containsWhitespace(): Boolean {
        return this.contains(Regex("\\s"))
    }

    fun getFullPath() : URL {

        val baseUrl = URL(baseApiUrl)

        return URL(baseUrl, baseApiPath)
    }

    fun safePrint() {
        println("baseApiUrl = $baseApiUrl")
        println("baseApiPath = $baseApiPath")
        println("username = $username")
        println("password = **********")
        println("projectId = $projectId")
        println("suiteId = $suiteId")
        println("runTitle = $runTitle")
        println("runDescription = $runDescription")
        println("proxyEnabled = $proxyEnabled")
        println("proxyHostname = $proxyHostname")
        println("proxyPort = $proxyPort")
    }
}