package YouTubeData_SearchVideos;


import YouTubeData_Channels.Request1;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Request2 {
    public static SearchListResponse requestSearchVideosListAsObject(String channelId, String apiKey) throws UnirestException {
        Request1.initApplication();
        HttpResponse<SearchListResponse> response = Unirest.get("https://www.googleapis.com/youtube/v3/search")
                .queryString("channelId", channelId)
                .queryString("part", "id")
                .queryString("fields", "items(id(videoId))")
                .queryString("maxResults", "49")
                .queryString("key", apiKey)
                .asObject(SearchListResponse.class);
        return response.getBody();
    }
}
