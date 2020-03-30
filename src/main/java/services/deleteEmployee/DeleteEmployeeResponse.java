package services.deleteEmployee;

import services.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteEmployeeResponse extends BaseResponse {

    private String status;
    private String message;
}
