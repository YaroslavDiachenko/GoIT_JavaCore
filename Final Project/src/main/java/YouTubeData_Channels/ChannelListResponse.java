package YouTubeData_Channels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ChannelListResponse {
    public List<Channel> items;

/*
    public void show() {
        System.out.println("--------------------------------" +
                        "\nsnippet.title: \t\t\t\t" + items.get(0).snippet.title +
//                "\nCreation date: \t\t" + snippet.publishedAt +
                        "\nstatistics.subscriberCount: " + items.get(0).statistics.subscriberCount +
                        "\nstatistics.videoCount: \t\t" + items.get(0).statistics.videoCount +
                        "\nstatistics.viewCount: \t\t" + items.get(0).statistics.viewCount +
                        "\nstatistics.commentCount: \t" + items.get(0).statistics.commentCount
        );
    }
*/
}
