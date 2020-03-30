package tests.smoke;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.createEmployee.CreateEmployeeRequest;
import services.createEmployee.CreateEmployeeRequestBuilder;
import services.createEmployee.CreateEmployeeResponse;
import services.deleteEmployee.DeleteEmployeeResponse;
import services.getEmployeesById.GetEmployeeByIdResponse;
import testBase.EmployeeTestBase;

public class EmployeeDeletionTest extends EmployeeTestBase {

    @DataProvider
    public Object[][] deleteData() {
        return new Object[][]{
                {"Del_" + RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomNumeric(5), RandomStringUtils.random(2, 22, 55, false, true)},
                {"Del_" + RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomNumeric(5), RandomStringUtils.random(2, 22, 55, false, true)},
        };
    }

    @Test(dataProvider = "deleteData", groups = "SMOKE")
    public void verifyEmployeeDeleteTest(String name, String salary, String age) throws Exception {

        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequestBuilder()
                .withAge(age)
                .withName(name)
                .withSalary(salary)
                .build();

        CreateEmployeeResponse response = employeeClientWrapper.createEmployee(createEmployeeRequest);
        response.assertCreateEmployee();
        response.assertEmployeeData(name, salary, age);
        context.setId(response.getData().getId());

        DeleteEmployeeResponse deleteEmployeeResponse = employeeClientWrapper.deleteEmployee(context.getId());
        deleteEmployeeResponse.AssertDeleteEmployee();

        DeleteEmployeeResponse deleteEmployeeResponse1 = employeeClientWrapper.deleteEmployee(context.getId());
        deleteEmployeeResponse1.assertDeleteEmployeeFailure();

        GetEmployeeByIdResponse getEmployeeByIdResponse = employeeClientWrapper.getEmployeeById(context.getId());
        getEmployeeByIdResponse.assertInvalidEmployee();
    }
}
