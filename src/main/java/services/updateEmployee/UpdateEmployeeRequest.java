package services.updateEmployee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeRequest {
    private String name;
    private String salary;
    private String age;
}
