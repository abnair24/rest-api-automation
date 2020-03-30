package tests.regression;

import org.testng.annotations.Test;
import services.deleteEmployee.DeleteEmployeeResponse;
import services.getEmployeesById.GetEmployeeByIdResponse;
import testBase.EmployeeTestBase;

public class DeleteEmployeeValidation extends EmployeeTestBase {

    @Test(groups = {"REGRESSION","EMPLOYEE"})
    public void nonExistentEmployeeDeletion() throws Exception {
        DeleteEmployeeResponse deleteEmployeeResponse = employeeClientWrapper.deleteEmployee(1001);
        deleteEmployeeResponse.assertDeleteEmployeeFailure();
    }
}
