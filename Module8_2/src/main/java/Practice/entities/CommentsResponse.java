package Practice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentsResponse {
    public String nextPageToken;
    public List<CommentThread> items;

    public void show() {
        System.out.println("NextPageToken: "+nextPageToken);
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Item#"+i+" CommentId: "+items.get(i).id+" Replies: "+items.get(i).snippet.totalReplyCount);
        }
    }
}
