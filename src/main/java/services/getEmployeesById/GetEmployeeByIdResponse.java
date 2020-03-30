package services.getEmployeesById;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import services.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import services.getEmployeesById.entities.Data;

@Getter
@Setter
public class GetEmployeeByIdResponse extends BaseResponse {

    private String status;
    private JsonNode data;

    private static final String ERROR_MESSAGE = "Record does not found.";

    public void assertGetEmployee() {
        Assert.assertEquals(getStatusCode(),200);
        Assert.assertEquals(getStatus(),"success");
    }

    public void assertEmployeeData(String id, String name, String salary, String age) {
        Assert.assertNotNull(getData());
        Assert.assertEquals(getData().get("id").textValue(),id);
        Assert.assertEquals(getData().get("employee_name").textValue(),name);
        Assert.assertEquals(getData().get("employee_salary").textValue(),salary);
        Assert.assertEquals(getData().get("employee_age").textValue(),age);
    }

    public void assertInvalidEmployee() {
        Assert.assertEquals(getStatus(),"failed");
        Assert.assertEquals(getStatusCode(),401);
        Assert.assertEquals(getData().textValue(),"Record does not found.");
    }
}
