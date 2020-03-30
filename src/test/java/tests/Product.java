package tests;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Product {
    String name;
    String category;

    Map<String, Object> details =new LinkedHashMap<>();

    @JsonAnySetter
    void setDetails(String key, Object value) {
        details.put(key,value);
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Map<String, Object> getDetails() {
        return details;
    }
}
