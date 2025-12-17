package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {

    public long id;
    public Category category;
    public String name;
    public List<String> photoUrls;   // ✅ added
    public List<Tag> tags;
    public String status;
}






