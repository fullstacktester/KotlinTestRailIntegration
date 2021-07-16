package io.github.fullstacktester.testrail

import io.github.fullstacktester.testrail.TestRail
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TestRailConfigTest {

    private val baseApiUrl = "http://example.com"
    private val baseApiPath = "path"
    private val username = "username"
    private val password = "password"
    private val projectId = 0
    private val suiteId = 0
    private val runTitle = "0"
    private val runDescription = "0"
    private val proxyEnabled = false
    private val proxyHostname = null
    private val proxyPort = null


    @Test
    fun `throws error when baseApiUri contains whitespace`() {
        val baseApiPathWithWhitespace = "path f"

        assertThrows<IllegalArgumentException> {
            TestRail(
                baseApiUrl,
                baseApiPathWithWhitespace,
                username,
                password,
                projectId,
                suiteId,
                runTitle,
                runDescription,
                proxyEnabled,
                proxyHostname,
                proxyPort
            )
        }
    }

    @Test
    fun `throws error when baseApiPath contains whitespace`() {
        val baseApiUrlWithWhitespace = "http://example. com"

        assertThrows<IllegalArgumentException> {
            TestRail(
                baseApiUrlWithWhitespace,
                baseApiPath,
                username,
                password,
                projectId,
                suiteId,
                runTitle,
                runDescription,
                proxyEnabled
            )
        }
    }

    @Test
    fun `creates valid full url when no forward slashes are provided`() {
        val baseApiUrlWithoutForwardSlash = "http://example.com"

        val expectedConfig = TestRail(
            baseApiUrlWithoutForwardSlash,
            baseApiPath,
            username,
            password,
            projectId,
            suiteId,
            runTitle,
            runDescription,
            proxyEnabled
        )

        expectedConfig.getFullPath().toString().shouldBe("http://example.com/path")
    }

    @Test
    fun `creates valid full url when both url and path provide forward slashes`() {
        val baseApiUrlWithForwardSlash = "http://example.com/"
        val baseApiPathWithForwardSlash = "/path"

        val expectedConfig = TestRail(
            baseApiUrlWithForwardSlash,
            baseApiPathWithForwardSlash,
            username,
            password,
            projectId,
            suiteId,
            runTitle,
            runDescription,
            proxyEnabled
        )

        expectedConfig.getFullPath().toString().shouldBe("http://example.com/path")
    }

    @Test
    fun `creates default full url when path is not provided`() {
        val baseApiUrl = "http://example.com/"
        val username = "username"
        val password = "password"
        val expectedConfig = TestRail(
            baseApiUrl = baseApiUrl,
            username = username,
            password = password,
            projectId = projectId,
            suiteId = suiteId,
            runTitle = runTitle,
            runDescription = runDescription,
            proxyEnabled = proxyEnabled
        )

        expectedConfig.getFullPath().toString().shouldBe("http://example.com/index.php?/api/v2/")
    }

    @Test
    fun `throws error is proxy is enabled but hostname is null`() {
        val proxyEnabled = true
        val proxyHostname = null
        val proxyPort = 1

        assertThrows<IllegalArgumentException> {
            TestRail(
                baseApiUrl,
                baseApiPath,
                username,
                password,
                projectId,
                suiteId,
                runTitle,
                runDescription,
                proxyEnabled,
                proxyHostname,
                proxyPort
            )
        }
    }

    @Test
    fun `throws error is proxy is enabled but hostname is empty`() {
        val proxyEnabled = true
        val proxyHostname = ""
        val proxyPort = 1

        assertThrows<IllegalArgumentException> {
            TestRail(
                baseApiUrl,
                baseApiPath,
                username,
                password,
                projectId,
                suiteId,
                runTitle,
                runDescription,
                proxyEnabled,
                proxyHostname,
                proxyPort
            )
        }
    }

    @Test
    fun `throws error is proxy is enabled but port is null`() {
        val proxyEnabled = true
        val proxyHostname = "hostname"
        val proxyPort = null

        assertThrows<IllegalArgumentException> {
            TestRail(
                baseApiUrl,
                baseApiPath,
                username,
                password,
                projectId,
                suiteId,
                runTitle,
                runDescription,
                proxyEnabled,
                proxyHostname,
                proxyPort
            )
        }
    }
}