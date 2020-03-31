package client;


import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.testng.Reporter;
import services.createEmployee.CreateEmployeeRequest;
import services.createEmployee.CreateEmployeeResponse;
import services.deleteEmployee.DeleteEmployeeResponse;
import services.getEmployees.GetEmployeesResponse;
import services.getEmployeesById.GetEmployeeByIdResponse;
import services.updateEmployee.UpdateEmployeeRequest;
import services.updateEmployee.UpdateEmployeeResponse;
import utils.EmployeeProperties;
import utils.Helper;

import static io.restassured.RestAssured.given;

public class EmployeeClient  {

    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest) {

        Reporter.log(String.format("\n CreateEmployeeURL -- POST %s", EmployeeProperties.createEmployeeURL), true);

        Reporter.log(String.format("\n CreateEmployeeRequest -- %s", Helper.getJson(createEmployeeRequest)), true);

        Response response = given()
                .header("User-Agent", "PostmanRuntime/7.23.0")
                .contentType(ContentType.JSON)
                .cookies("PHPSESSID", "9878b0383c39b00401f177bc164bd652",
                        "ezCMPCCS", "true",
                        "ezepvv", "0",
                        "ezovuuidtime_133674", "1585559559",
                        "ezoadgid_133674", "-1",
                        "ezoab_133674", "mod55",
                        "active_template::133674", "pub_site.1585569914")
                .body(createEmployeeRequest)
                .when()
                .post(EmployeeProperties.createEmployeeURL);

        Reporter.log(String.format("\n CreateEmployee Response: %s %s", response.getStatusCode(),response.asString()), true);

        CreateEmployeeResponse createEmployeeResponse = response.as(CreateEmployeeResponse.class);
        createEmployeeResponse.setStatusCode(response.getStatusCode());

        return createEmployeeResponse;
    }

    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest updateEmployeeRequest, int id) {

        Reporter.log(String.format("\n UpdateEmployeeURL -- PUT %s", EmployeeProperties.updateEmployeeURL + id), true);

        Reporter.log(String.format("\n UpdateEmployeeRquest -- %s", Helper.getJson(updateEmployeeRequest)), true);

        Response response = given()
                .header("User-Agent", "PostmanRuntime/7.23.0")
                .contentType(ContentType.JSON)
                .cookies("PHPSESSID", "9878b0383c39b00401f177bc164bd652",
                        "ezCMPCCS", "true",
                        "ezepvv", "0",
                        "ezovuuidtime_133674", "1585559559",
                        "ezoadgid_133674", "-1",
                        "ezoab_133674", "mod55",
                        "active_template::133674", "pub_site.1585569914")
                .body(updateEmployeeRequest)
                .put(EmployeeProperties.updateEmployeeURL + id);

        Reporter.log(String.format("\n UpdateEmployee Response: %s %s", response.getStatusCode(),response.asString()), true);

        UpdateEmployeeResponse updateEmployeeResponse = response.as(UpdateEmployeeResponse.class);
        updateEmployeeResponse.setStatusCode(response.getStatusCode());

        return updateEmployeeResponse;
    }

    public DeleteEmployeeResponse deleteEmployee(int id) {

        Reporter.log(String.format("\n DeleteEmployeeURL -- DELETE %s", EmployeeProperties.deleteEmployeeURL + id), true);

        Response response = given()
                .header("User-Agent", "PostmanRuntime/7.23.0")
                .contentType(ContentType.JSON)
                .cookies("PHPSESSID", "9878b0383c39b00401f177bc164bd652",
                        "ezCMPCCS", "true",
                        "ezepvv", "0",
                        "ezovuuidtime_133674", "1585559559",
                        "ezoadgid_133674", "-1",
                        "ezoab_133674", "mod55",
                        "active_template::133674", "pub_site.1585569914")
                .when()
                .delete(EmployeeProperties.deleteEmployeeURL + id);

        Reporter.log(String.format("\n DeleteEmployee Response: %s %s", response.getStatusCode(),response.asString()), true);

        DeleteEmployeeResponse deleteEmployeeResponse = response.as(DeleteEmployeeResponse.class);
        deleteEmployeeResponse.setStatusCode(response.getStatusCode());

        return deleteEmployeeResponse;
    }

    public GetEmployeeByIdResponse getEmployeeById(int id) {

        Reporter.log(String.format("\n GetEmployeeById URL -- GET %s", EmployeeProperties.getEmployeeByIdURL + id), true);

        Response response = given()
                .header("User-Agent", "PostmanRuntime/7.23.0")
                .header("Content-Type", "application/json")
                .cookie("PHPSESSID", "9878b0383c39b00401f177bc164bd652",
                        "ezCMPCCS", "true",
                        "ezepvv", "0",
                        "ezovuuidtime_133674", "1585559559",
                        "ezoadgid_133674", "-1",
                        "ezoab_133674", "mod55",
                        "active_template::133674", "pub_site.1585569914")

                .when()
                .get(EmployeeProperties.getEmployeeByIdURL + id);

        Reporter.log(String.format("\n GetEmployeeById Response: %s %s", response.getStatusCode(),response.asString()), true);

        GetEmployeeByIdResponse getEmployeeByIdResponse = response.as(GetEmployeeByIdResponse.class);
        getEmployeeByIdResponse.setStatusCode(response.getStatusCode());

        return getEmployeeByIdResponse;
    }

    public GetEmployeesResponse getEmployees() {

        Reporter.log(String.format("\n GetEmployeesURL -- GET %s", EmployeeProperties.getEmployeesURL), true);

        Response response = given()
                .header("User-Agent", "PostmanRuntime/7.23.0")
                .contentType(ContentType.JSON)
                .when()
                .get(EmployeeProperties.getEmployeesURL);

        Reporter.log(String.format("\n GetEmployees Response: %s %s", response.getStatusCode(),response.asString()), true);

        GetEmployeesResponse getEmployeesResponse = response.as(GetEmployeesResponse.class);
        getEmployeesResponse.setStatusCode(response.getStatusCode());

        return getEmployeesResponse;
    }
}
