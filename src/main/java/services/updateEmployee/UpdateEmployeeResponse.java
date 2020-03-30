package services.updateEmployee;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.testng.Assert;
import services.BaseResponse;

import java.util.LinkedHashMap;
import java.util.Map;

public class UpdateEmployeeResponse extends BaseResponse {

    private String status;
    private Map<String,Object> data = new LinkedHashMap<>();

    public void assertUpdateEmployee() throws Exception {
        Assert.assertEquals(getStatusCode(), 200);
        Assert.assertNotNull(getData());
        Assert.assertEquals(getStatus(), "success");
    }

    public void assertInvalideUpdateEmployee() throws Exception {
        Assert.assertEquals(getStatusCode(), 401);
        Assert.assertEquals(getStatus(), "failed");
        Assert.assertEquals(getData(), "Record does not found.");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getData() {
        return data;
    }

    @JsonAnySetter
    public void setData(String key, Object value) {
        data.put(key,value);
    }
}
