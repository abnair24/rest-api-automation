package services.updateEmployee;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import services.BaseResponse;
import services.updateEmployee.entities.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class UpdateEmployeeResponse extends BaseResponse {

    private String status;

    private JsonNode data;

    public void assertUpdateEmployee() throws Exception {
        Assert.assertEquals(getStatusCode(), 200);
        Assert.assertNotNull(getData());
        Assert.assertEquals(getStatus(), "success");
    }

    public void assertInvalideUpdateEmployee() throws Exception {
        Assert.assertEquals(getStatusCode(), 401);
        Assert.assertEquals(getStatus(), "failed");
        Assert.assertEquals(getData().textValue(), "Record does not found.");
    }

}
