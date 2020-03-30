package testBase;


import clientWrapper.EmployeeClientWrapper;

import io.restassured.RestAssured;

import io.restassured.parsing.Parser;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import utils.Context;

import java.lang.reflect.Method;

import static io.restassured.config.SSLConfig.sslConfig;

public class EmployeeTestBase {

    public EmployeeClientWrapper employeeClientWrapper;
    public Context context = new Context();

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        //RestAssured.config = RestAssured.config().sslConfig(sslConfig().relaxedHTTPSValidation());
        RestAssured.defaultParser = Parser.JSON;

        employeeClientWrapper = new EmployeeClientWrapper(context);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() throws Exception {
        Reporter.log(String.format("Finished execution %s",getClass().getTypeName()),true);
    }

}
