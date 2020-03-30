package services.updateEmployee;

public class UpdateEmployeeRequestBuilder {

    UpdateEmployeeRequest updateEmployeeRequest;

    public UpdateEmployeeRequestBuilder() {
        updateEmployeeRequest = new UpdateEmployeeRequest();
    }

    public UpdateEmployeeRequest build() {
        return updateEmployeeRequest;
    }

    public UpdateEmployeeRequestBuilder withName(String name) {
        updateEmployeeRequest.setName(name);
        return this;
    }

    public UpdateEmployeeRequestBuilder withAge(String age) {
        updateEmployeeRequest.setAge(age);
        return this;
    }

    public UpdateEmployeeRequestBuilder withSalary(String salary) {
        updateEmployeeRequest.setSalary(salary);
        return this;
    }

}
