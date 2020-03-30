package services;

import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;

@Setter
@Getter
public class BaseResponse {

    public int statusCode;

//    public void assertHttpStatusCode(int statusCode) {
//        assertEquals(getStatusCode(),statusCode,"Http Status code mismatch");
//    }
}
