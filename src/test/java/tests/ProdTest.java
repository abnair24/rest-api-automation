package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProdTest {

   @Test
    public void test1() throws Exception {
        String json = "{\n" +
                "    \"name\": \"Pear yPhone 72\",\n" +
                "    \"category\": \"cellphone\",\n" +
                "    \"details\": {\n" +
                "        \"displayAspectRatio\": \"97:3\",\n" +
                "        \"audioConnector\": \"none\"\n" +
                "    }\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();

        Product product = objectMapper.readValue(json, Product.class);

        Assert.assertEquals(product.getName(),"Pear yPhone 72");
        Assert.assertEquals(product.getDetails().get("audioConnector"),"none");
    }



}
