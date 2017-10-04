package YouTubeData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class OneChannel {
    public Snippet snippet;
    public Statistics statistics;


}
