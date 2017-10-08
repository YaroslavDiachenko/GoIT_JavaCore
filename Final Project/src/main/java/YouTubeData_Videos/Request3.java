package YouTubeData_Videos;


import YouTubeData_Channels.Request1;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Request3 {
    public static String requestVideoDataAsObject(String videosList, String apiKey) throws UnirestException {
        Request1.initApplication();
        HttpResponse<String> response = Unirest.get("https://www.googleapis.com/youtube/v3/videos")
                .queryString("id", videosList)
                .queryString("part", "statistics")
                .queryString("maxResults", "50")
                .queryString("key", apiKey)
                .asString();
        return response.getBody();
    }
}
