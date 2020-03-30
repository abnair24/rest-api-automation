package services.updateEmployee;

import services.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import services.createEmployee.entities.Data;

@Getter
@Setter
public class UpdateEmployeeResponse extends BaseResponse {

    private String status;
    private Data data;
}
