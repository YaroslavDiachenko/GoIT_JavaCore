package YouTubeData_SearchVideos;

import YouTubeData_SearchVideos.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class SearchResult {
    public Id id;
}
