package io.github.fullstacktester.testrail

@Target(AnnotationTarget.FUNCTION)
annotation class ReportToTestRail(val id: String = "UNDEFINED")