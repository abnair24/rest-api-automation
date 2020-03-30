package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import services.createEmployee.CreateEmployeeRequest;
import services.createEmployee.CreateEmployeeResponse;
import services.deleteEmployee.DeleteEmployeeResponse;
import services.getEmployees.GetEmployeesResponse;
import services.getEmployeesById.GetEmployeeByIdResponse;
import services.updateEmployee.UpdateEmployeeRequest;
import services.updateEmployee.UpdateEmployeeResponse;
import utils.EmployeeProperties;

import static io.restassured.RestAssured.given;

public class EmployeeClient extends BaseClient {

    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest) {

        Response response = given()
                .contentType(ContentType.JSON)
                .body(createEmployeeRequest)
                .when()
                .post(EmployeeProperties.createEmployeeURL);

        System.out.println(response.asString());

        CreateEmployeeResponse createEmployeeResponse = response.as(CreateEmployeeResponse.class);
        createEmployeeResponse.setStatusCode(response.getStatusCode());

        return createEmployeeResponse;
    }

    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest updateEmployeeRequest, int id) {
        RequestSpecification specification = given()
                .contentType(ContentType.JSON)
                .body(updateEmployeeRequest);
        Response response = put(EmployeeProperties.updateEmployeeURL + id, specification);

        UpdateEmployeeResponse updateEmployeeResponse = response.as(UpdateEmployeeResponse.class);
        updateEmployeeResponse.setStatusCode(response.getStatusCode());

        return updateEmployeeResponse;
    }

    public DeleteEmployeeResponse deleteEmployee(int id) {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete(EmployeeProperties.deleteEmployeeURL + id);

        DeleteEmployeeResponse deleteEmployeeResponse = response.as(DeleteEmployeeResponse.class);
        deleteEmployeeResponse.setStatusCode(response.getStatusCode());

        return deleteEmployeeResponse;
    }

    public GetEmployeeByIdResponse getEmployeeById(int id) {

        RestAssured.baseURI = "http://dummy.restapiexample.com";
        Response response = given()
               // .header("Content-Type","application/json")
                .pathParam("id",id)
                .when()
                .get("/api/v1/employee/{id}");

                response.then().statusCode(200);

//        RequestSpecification specification = given()
//                .contentType(ContentType.JSON);
//        Response response = get(EmployeeProperties.getEmployeeByIdURL +"/12", specification);
//
////        Response response = given()
////                .contentType(ContentType.JSON)
////                .when()
////                .get("http://dummy.restapiexample.com/api/v1/employee/12");
//
        System.out.println(response.asString());

        GetEmployeeByIdResponse getEmployeeByIdResponse = response.as(GetEmployeeByIdResponse.class);
        getEmployeeByIdResponse.setStatusCode(response.getStatusCode());

        return getEmployeeByIdResponse;
    }

    public GetEmployeesResponse getEmployees() {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(EmployeeProperties.getEmployeesURL);

        GetEmployeesResponse getEmployeesResponse = response.as(GetEmployeesResponse.class);
        getEmployeesResponse.setStatusCode(response.getStatusCode());

        return getEmployeesResponse;
    }
}
