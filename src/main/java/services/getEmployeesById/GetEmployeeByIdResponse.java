package services.getEmployeesById;

import services.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import services.getEmployeesById.entities.Data;

@Getter
@Setter
public class GetEmployeeByIdResponse extends BaseResponse {

    private String status;
    private Data data;
  //  private String data_message;
    private static final String ERROR_MESSAGE = "Record does not found.";

    public void assertGetEmployee() {
        Assert.assertEquals(getStatusCode(),200);
        Assert.assertEquals(getStatus(),"success");
    }

    public void assertEmployeeData(String id, String name, String salary, String age) {
        Assert.assertNotNull(getData());
     //   Assert.assertNotEquals(getData_message(),ERROR_MESSAGE);
        Assert.assertEquals(getData().getId(),id);
        Assert.assertEquals(getData().getEmployee_name(),name);
        Assert.assertEquals(getData().getEmployee_salary(),salary);
        Assert.assertEquals(getData().getEmployee_age(),age);
    }

    public void assertInvalidEmployee() {
       // Assert.assertEquals(getData_message(),ERROR_MESSAGE);
        Assert.assertEquals(getStatus(),"failed");
        Assert.assertEquals(getStatusCode(),401);
    }
}
