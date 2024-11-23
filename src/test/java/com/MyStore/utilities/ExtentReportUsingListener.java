package com.MyStore.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUsingListener implements ITestListener {
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void configureReport() {
        ReadConfig readConfig = new ReadConfig();
        String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        String reportName = "MyStoreT estReport-" + timestamp + ".html";
        htmlReporter = new ExtentSparkReporter("D:\\Sakshi\\CareerLearnings\\SeleniumAutomation\\Reports\\" + reportName);
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

    //onStart method is called when any test starts only once.
    public void onStart(ITestContext Result) {
        configureReport();
        System.out.println("On start method invoked...");
    }

    //when all test methods are executed onFinish method starts running
    public void onFinsh(ITestContext Result) {
        System.out.println("On finish method invoked...");
        reports.flush(); //it is mandatory to call flush method to ensure info is written to the started reporter.
    }

    public void onTestFailure(ITestContext Result) {
        System.out.println("Name of the test method failed: " + Result.getName());
        test = reports.createTest(Result.getName()); //create entry in html report
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.RED));
        String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png";
        File screenshotFile = new File(screenshotPath);
        if (screenshotFile.exists()) {
            test.fail("Captured screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));
        }
//        test.addScreenCaptureFromPath(screenshotPath);
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

    public void onTestFailedWithinSuccessPercentage(ITestContext Result) {

    }
}
