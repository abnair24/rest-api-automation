package utils;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Helper {

    public static String getJson(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static Object getResponseObject(String response, Class responseClass) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response,responseClass);
    }
}
