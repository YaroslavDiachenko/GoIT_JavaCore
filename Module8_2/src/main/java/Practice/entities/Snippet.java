package Practice.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Snippet {
    public String authorDisplayName;
    public String textOriginal;
    public int likeCount;
    public String updatedAt;
}
