package tests.smoke;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.createEmployee.CreateEmployeeRequest;
import services.createEmployee.CreateEmployeeRequestBuilder;
import services.createEmployee.CreateEmployeeResponse;
import services.getEmployees.GetEmployeesResponse;
import services.getEmployeesById.GetEmployeeByIdResponse;
import testBase.EmployeeTestBase;

public class EmployeeSearchTest extends EmployeeTestBase {

    @DataProvider
    public Object[][] newEmployeeData() {
        return new Object[][]{
                {"Dummy1_" + RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomNumeric(5), RandomStringUtils.random(2, 22, 55, false, true)},
                {"Dummy2_" + RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomNumeric(5), RandomStringUtils.random(2, 22, 55, false, true)},
        };
    }


    @Test(dataProvider = "newEmployeeData", groups = "SMOKE")
    public void verifyEmployeeSearchById(String name, String salary, String age) throws Exception {

        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequestBuilder()
                .withAge(age)
                .withName(name)
                .withSalary(salary)
                .build();

        CreateEmployeeResponse response = employeeClientWrapper.createEmployee(createEmployeeRequest);
        response.assertCreateEmployee();
        response.assertEmployeeData(name, salary, age);
        context.setId(response.getData().getId());

        GetEmployeeByIdResponse getEmployeeByIdResponse = employeeClientWrapper.getEmployeeById(context.getId());
        getEmployeeByIdResponse.assertGetEmployee();
        getEmployeeByIdResponse.assertEmployeeData(String.valueOf(context.getId()), name, salary, age);
    }

    @Test(groups = "SMOKE")
    public void verifyAllEmployeesTest() throws Exception {

        GetEmployeesResponse response = employeeClientWrapper.getEmployees();
        response.assertGetEmployees();
    }



}
