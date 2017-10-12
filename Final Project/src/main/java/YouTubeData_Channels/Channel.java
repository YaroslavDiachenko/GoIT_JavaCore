package YouTubeData_Channels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Channel {
    public Snippet snippet;
    public Statistics statistics;


}
