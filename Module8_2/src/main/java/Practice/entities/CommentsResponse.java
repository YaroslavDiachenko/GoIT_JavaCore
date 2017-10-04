package Practice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentsResponse {
    public List<Comment> items;

    public void show() {
        int n = 1;
        for (Comment i : items) {
            System.out.println("Comment#" + n++);
            System.out.println("Can reply: \t\t" + i.snippet.canReply);
            System.out.println("Author: \t\t" + i.snippet.topLevelComment.snippet.authorDisplayName);
            System.out.println("Updated at: \t" + i.snippet.topLevelComment.snippet.updatedAt);
            System.out.println("Likes: \t\t\t" + i.snippet.topLevelComment.snippet.likeCount);
            System.out.println("Comment: \t\t" + i.snippet.topLevelComment.snippet.textOriginal);
            System.out.println("-----------------");
        }
    }
}
