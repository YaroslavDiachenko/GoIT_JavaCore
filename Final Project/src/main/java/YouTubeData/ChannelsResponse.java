package YouTubeData;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ChannelsResponse {
    public List<OneChannel> items;

    public void show() {
        System.out.println("--------------------------------" +
                        "\nsnippet.title: \t\t" + items.get(0).snippet.title +
//                "\nCreation date: \t\t" + snippet.publishedAt +
                        "\nstatistics.subscriberCount: \t\t" + items.get(0).statistics.subscriberCount +
                        "\nstatistics.videoCount: \t\t" + items.get(0).statistics.videoCount +
                        "\nstatistics.viewCount: \t\t" + items.get(0).statistics.viewCount +
                        "\nstatistics.commentCount: \t\t" + items.get(0).statistics.commentCount
        );
    }
}
