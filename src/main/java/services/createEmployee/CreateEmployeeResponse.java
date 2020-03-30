package services.createEmployee;

import services.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import services.createEmployee.entities.Data;

@Getter
@Setter
public class CreateEmployeeResponse extends BaseResponse {

    private String status;
    private Data data;

    public void assertCreateEmployee() {
        Assert.assertEquals(getStatusCode(), 200);
        Assert.assertEquals(getStatus(), "success");
    }

    public void assertEmployeeData(String name, String salary, String age) {
        Assert.assertEquals(getData().getName(),name);
        Assert.assertEquals(getData().getAge(),age);
        Assert.assertEquals(getData().getSalary(),salary);
    }
}
