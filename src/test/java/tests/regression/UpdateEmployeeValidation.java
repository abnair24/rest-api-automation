package tests.regression;

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

public class UpdateEmployeeValidation extends EmployeeTestBase {

    @Test(groups = {"REGRESSION","EMPLOYEE"})
    public void nonExistentEmployeeUpdation() throws Exception {

        UpdateEmployeeRequest updateEmployeeRequest = new UpdateEmployeeRequestBuilder()
                .withAge("20")
                .withName("dummy_name")
                .withSalary("121212")
                .build();

        UpdateEmployeeResponse updateEmployeeResponse = employeeClientWrapper.updateEmployee(updateEmployeeRequest, 101);
        updateEmployeeResponse.assertInvalideUpdateEmployee();
    }

    @DataProvider
    public Object[][] updateData() {
        return new Object[][]{
                {"X_" + RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomNumeric(5), RandomStringUtils.random(2, 22, 55, false, true)},
                {"Y_" + RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomNumeric(5), RandomStringUtils.random(2, 22, 55, false, true)},

        };
    }

    @Test(dataProvider = "updateData", groups = {"REGRESSION","EMPLOYEE"})
    public void emptyDataUpdation(String name, String salary, String age) throws Exception {
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
                .withAge("")
                .withName("")
                .withSalary("")
                .build();

        UpdateEmployeeResponse updateEmployeeResponse = employeeClientWrapper.updateEmployee(updateEmployeeRequest, context.getId());
        updateEmployeeResponse.assertUpdateEmployee();

        GetEmployeeByIdResponse getEmployeeByIdResponse = employeeClientWrapper.getEmployeeById(context.getId());
        getEmployeeByIdResponse.assertGetEmployee();
    }
}
