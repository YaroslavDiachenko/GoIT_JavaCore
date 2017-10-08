package YouTubeData_Videos;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class VideoListResponse {
    public List<Video> items;

}
