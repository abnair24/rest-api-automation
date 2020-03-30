package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateTest {

    @Test
    public void test() throws Exception{
        String json = "{\n" +
                "    \"status\": \"failed\",\n" +
                "    \"data\": \"Record does not found.\"\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();

        Update update = objectMapper.readValue(json, Update.class);

        Assert.assertEquals(update.getStatus(),"success");
        Assert.assertEquals(update.getData(),"Record does not found.");
    }
}
