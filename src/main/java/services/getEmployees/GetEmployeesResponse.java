package services.getEmployees;

import services.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import services.getEmployees.entities.Data;


import java.util.List;

@Getter
@Setter
public class GetEmployeesResponse extends BaseResponse {

    private String status;
    private List<Data> data;


    public void assertGetEmployees() {
        Assert.assertEquals(getStatusCode(),200);
        Assert.assertEquals(getStatus(),"success");
        Assert.assertNotNull(getData());
    }
}
