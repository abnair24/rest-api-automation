package services.createEmployee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeeRequest {

    private String name;
    private String salary;
    private String age;
}
