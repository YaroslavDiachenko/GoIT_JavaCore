package Practice.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentThread {
    public String id;
    public Snippet snippet;
}
