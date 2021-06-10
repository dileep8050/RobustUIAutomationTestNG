package com.learn.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.learn.reports.ExtentLogger;
import com.learn.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener {
	public void onStart(ISuite suite) {
			ExtentReport.initExtentReport();
		}

		public void onFinish(ISuite suite) {
			ExtentReport.flushReports();
		}

		public void onTestStart(ITestResult result) {
			ExtentReport.createTest(result.getMethod().getMethodName());
		}

		public void onTestSuccess(ITestResult result) {
			ExtentLogger.pass(result.getMethod().getMethodName()+" : is passed");
		}

		public void onTestFailure(ITestResult result) {
			ExtentLogger.fail(result.getMethod().getMethodName()+" : is Fail");
		}

		public void onTestSkipped(ITestResult result) {
			ExtentLogger.skip(result.getMethod().getMethodName()+" : is skipped");
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		}

		public void onTestFailedWithTimeout(ITestResult result) {
		}

		public void onStart(ITestContext context) {
		}

		public void onFinish(ITestContext context) {
		}
}
