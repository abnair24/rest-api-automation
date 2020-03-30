package tests.smoke;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.createEmployee.CreateEmployeeRequest;
import services.createEmployee.CreateEmployeeRequestBuilder;
import services.createEmployee.CreateEmployeeResponse;
import services.getEmployeesById.GetEmployeeByIdResponse;
import services.updateEmployee.UpdateEmployeeRequest;
import services.updateEmployee.UpdateEmployeeRequestBuilder;
import services.updateEmployee.UpdateEmployeeResponse;
import testBase.EmployeeTestBase;

public class EmployeeUpdationTest extends EmployeeTestBase {

    @DataProvider
    public Object[][] updateData() {
        return new Object[][]{
                {"X_" + RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomNumeric(5), RandomStringUtils.random(2, 22, 55, false, true), "UpdateName"},
                {"Y_" + RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomNumeric(5), RandomStringUtils.random(2, 22, 55, false, true), "UpdateName"},

        };
    }

    @Test(dataProvider = "updateData", groups = {"SMOKE","EMPLOYEE"})
    public void verifyEmployeeUpdateTest(String name, String salary, String age, String updateName) throws Exception {

        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequestBuilder()
                .withAge(age)
                .withName(name)
                .withSalary(salary)
                .build();

        CreateEmployeeResponse response = employeeClientWrapper.createEmployee(createEmployeeRequest);
        response.assertCreateEmployee();
        response.assertEmployeeData(name, salary, age);
        context.setId(response.getData().getId());

        UpdateEmployeeRequest updateEmployeeRequest = new UpdateEmployeeRequestBuilder()
                .withAge(age)
                .withName(updateName)
                .withSalary(salary)
                .build();

        UpdateEmployeeResponse updateEmployeeResponse = employeeClientWrapper.updateEmployee(updateEmployeeRequest,context.getId());
        updateEmployeeResponse.assertUpdateEmployee();

        GetEmployeeByIdResponse getEmployeeByIdResponse = employeeClientWrapper.getEmployeeById(context.getId());

        Assert.assertEquals(getEmployeeByIdResponse.getData().get("employee_name").textValue(), updateName);
    }
}
