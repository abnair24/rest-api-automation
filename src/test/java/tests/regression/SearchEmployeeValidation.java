package tests.regression;

import org.testng.annotations.Test;
import services.createEmployee.CreateEmployeeRequest;
import services.createEmployee.CreateEmployeeRequestBuilder;
import services.createEmployee.CreateEmployeeResponse;
import services.getEmployeesById.GetEmployeeByIdResponse;
import testBase.EmployeeTestBase;

public class SearchEmployeeValidation extends EmployeeTestBase {

    @Test(groups = "REGRESSION")
    public void invalidIdSearchTest() throws Exception {

        GetEmployeeByIdResponse getEmployeeByIdResponse = employeeClientWrapper.getEmployeeById(1001);
        getEmployeeByIdResponse.assertInvalidEmployee();
    }

}
