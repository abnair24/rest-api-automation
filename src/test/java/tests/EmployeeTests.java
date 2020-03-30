package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.createEmployee.CreateEmployeeRequest;
import services.createEmployee.CreateEmployeeRequestBuilder;
import services.createEmployee.CreateEmployeeResponse;
import services.getEmployees.GetEmployeesResponse;
import services.getEmployeesById.GetEmployeeByIdResponse;
import testBase.EmployeeTestBase;

public class EmployeeTests extends EmployeeTestBase {

    @DataProvider
    public Object[][] employeeData() {
        return new Object[][]{
                {"Test1_" + RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomNumeric(5), RandomStringUtils.random(2, 22, 55, false, true)},
//                {"Test2_" + RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomNumeric(5), RandomStringUtils.random(2, 22, 55, false, true)},
//                {"Test3_" + RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomNumeric(5), RandomStringUtils.random(2, 22, 55, false, true)},
//                {"Test4_" + RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomNumeric(5), RandomStringUtils.random(2, 22, 55, false, true)},
//                {"Test5_" + RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomNumeric(5), RandomStringUtils.random(2, 22, 55, false, true)},
        };
    }


    @Test(dataProvider = "employeeData", groups = {"SMOKE", "REGRESSION"})
    public void test1(String name, String salary, String age) throws Exception {

        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequestBuilder()
                .withAge(age)
                .withName(name)
                .withSalary(salary)
                .build();

        CreateEmployeeResponse response = employeeClientWrapper.createEmployee(createEmployeeRequest);
        response.assertCreateEmployee();
        response.assertEmployeeData(name,salary,age);
        context.setId(response.getData().getId());

        GetEmployeeByIdResponse getEmployeeByIdResponse = employeeClientWrapper.getEmployeeById(85);
        getEmployeeByIdResponse.assertGetEmployee();
        getEmployeeByIdResponse.assertEmployeeData(String.valueOf(context.getId()),name,salary,age);
    }

    @Test(groups= {"SMOKE"})
    public void test() throws Exception {

        GetEmployeesResponse response = employeeClientWrapper.getEmployees();
        response.assertGetEmployees();
    }
}
