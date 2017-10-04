package YouTubeData;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class Request {

    static ChannelsResponse channelsResponse;
    static String myApiKey = "AIzaSyBifuUatBiNP7C8X2zjMM1BJWinnrES6Ic";
//    static String channelId = "UCJALCpMORvQrlN7dAPLiCWg";

    public static OneChannel requestYouTubeChannel(String channelId) throws UnirestException {
        ChannelsResponse channelsResponse = getChannelData(channelId);
        return channelsResponse.items.get(0);
    }

    private static void initApplication() {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private static ChannelsResponse getChannelData(String channelId) throws UnirestException {
        initApplication();
        HttpResponse<ChannelsResponse> response = Unirest.get("https://www.googleapis.com/youtube/v3/channels")
                .queryString("id", channelId)
                .queryString("part", "snippet,statistics")
                .queryString("key", myApiKey)
                .asObject(ChannelsResponse.class);
        return response.getBody();
    }
}
