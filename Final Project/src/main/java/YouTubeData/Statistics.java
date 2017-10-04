package YouTubeData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Statistics {
    public int subscriberCount;
    public int videoCount;
    public int viewCount;
    public int commentCount;
}
