package services.createEmployee;

public class CreateEmployeeRequestBuilder {

    CreateEmployeeRequest createEmployeeRequest;

    public CreateEmployeeRequestBuilder() {
        createEmployeeRequest = new CreateEmployeeRequest();
    }

    public CreateEmployeeRequest build() {
        return createEmployeeRequest;
    }

    public CreateEmployeeRequestBuilder withName(String name) {
        createEmployeeRequest.setName(name);
        return this;
    }

    public CreateEmployeeRequestBuilder withAge(String age) {
        createEmployeeRequest.setAge(age);
        return this;
    }

    public CreateEmployeeRequestBuilder withSalary(String salary) {
        createEmployeeRequest.setSalary(salary);
        return this;
    }
}
