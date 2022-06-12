package CommonUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
    static ExtentReports extentReports;

    public static ExtentReports getReportObject() {
        ExtentSparkReporter extentSpartReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//testexecution.html");
        extentSpartReporter.config().setReportName("Test Automation Report");
        extentSpartReporter.config().setDocumentTitle("Ecommerce Test Report");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSpartReporter);
        extentReports.setSystemInfo("Tester", "Abdelhamid elnaggar");
        return extentReports;
    }
}
