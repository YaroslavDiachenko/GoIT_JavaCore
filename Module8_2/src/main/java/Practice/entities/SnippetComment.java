package Practice.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SnippetComment {
    public boolean canReply;
    public TopLevelComment topLevelComment;
}
