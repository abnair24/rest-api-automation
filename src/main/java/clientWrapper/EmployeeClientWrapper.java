package clientWrapper;

import client.EmployeeClient;
import services.createEmployee.CreateEmployeeRequest;
import services.createEmployee.CreateEmployeeResponse;
import services.deleteEmployee.DeleteEmployeeResponse;
import services.getEmployees.GetEmployeesResponse;
import services.getEmployeesById.GetEmployeeByIdResponse;
import services.updateEmployee.UpdateEmployeeRequest;
import services.updateEmployee.UpdateEmployeeResponse;
import utils.Context;

public class EmployeeClientWrapper {

    private EmployeeClient client;
    private Context context;

    public EmployeeClientWrapper(Context context) {
        client = new EmployeeClient();
        this.context = context;
    }

    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest request) {
        return client.createEmployee(request);
    }

    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest request,int id) {
        return client.updateEmployee(request,id);
    }

    public DeleteEmployeeResponse deleteEmployee(int id) {
        return client.deleteEmployee(id);
    }

    public GetEmployeesResponse getEmployees() {
        return client.getEmployees();
    }

    public GetEmployeeByIdResponse getEmployeeById(int id) {
        return client.getEmployeeById(id);
    }


}
