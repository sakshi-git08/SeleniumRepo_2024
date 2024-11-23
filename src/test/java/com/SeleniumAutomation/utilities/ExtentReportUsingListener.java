package com.SeleniumAutomation.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class ExtentReportUsingListener implements ITestListener {
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void configureReport() {
        htmlReporter = new ExtentSparkReporter("ExtentListenerReport.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        //add system info/env info to reports
        reports.setSystemInfo("OS:", "Windows 11");
        reports.setSystemInfo("browser:", "chrome");
        reports.setSystemInfo("username:", "Sakshi Aggarwal");

        //configuration to change look and feel of report
        htmlReporter.config().setDocumentTitle("MyStore Automation Report");
        htmlReporter.config().setReportName("MyStore Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onStart(ITestContext Result) {
        configureReport();
        System.out.println("On start method invoked...");
    }

    public void onFinsh(ITestContext Result) {
        System.out.println("On finish method invoked...");
        reports.flush();
    }

    public void onTestFailure(ITestContext Result) {
        System.out.println("Name of the test method failed: " + Result.getName());
        test = reports.createTest(Result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.RED));
    }

    public void onTestSkipped(ITestContext Result) {
        System.out.println("Name of test method skipped: " + Result.getName());
        test = reports.createTest(Result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.YELLOW));
    }

    public void onTestSuccess(ITestContext Result) {
        System.out.println("Name of test method skipped: " + Result.getName());
        test = reports.createTest(Result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.GREEN));

    }

    public void onTestFailedWithinSuccessPercentage(ITestContext Result){

    }
}
