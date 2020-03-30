package services.deleteEmployee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.testng.Assert;
import services.BaseResponse;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteEmployeeResponse extends BaseResponse {

    private String status;
    private String message;

    public void AssertDeleteEmployee() {
        Assert.assertEquals(getStatus(),"success");
        Assert.assertEquals(getStatusCode(),200);
        Assert.assertEquals(getMessage(),"successfully! deleted Records");
    }

    public void assertDeleteEmployeeFailure() {
        Assert.assertEquals(getStatusCode(),200);
        Assert.assertEquals(getStatus(),"failed");
        Assert.assertEquals(getMessage(),"Error! Id must be greater than zerp");
    }
}
