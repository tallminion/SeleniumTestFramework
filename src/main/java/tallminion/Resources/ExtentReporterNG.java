package tallminion.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReporterNG {
    public void getReportObject(){
        String path = System.getProperty("user.dir")+ File.separator+"reports"+File.separator+"index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setReportName("Web Automation reports");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Ganti Sai Sagar");

    }
}
