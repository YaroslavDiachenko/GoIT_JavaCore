

import Entities.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Main {

    static String myApiKey = "AIzaSyBifuUatBiNP7C8X2zjMM1BJWinnrES6Ic";
    static List<String> links = new ArrayList<>();
    static List<CommentsResponse> list = new ArrayList<>();

    public static void main(String[] args) throws UnirestException {
        String channelId = "JsKIZdXhnho";

/*
        CommentsResponse commentsResponse = getComments(channelId);
        commentsResponse.show();

        CommentsResponse commentsResponse2 = getCommentsNextPage(channelId,commentsResponse.nextPageToken);
        commentsResponse2.show();

        CommentsResponse commentsResponse3 = getCommentsNextPage(channelId,commentsResponse2.nextPageToken);
        commentsResponse3.show();

        CommentsResponse commentsResponse4 = getCommentsNextPage(channelId,commentsResponse3.nextPageToken);
        commentsResponse4.show();
*/

        System.out.println(getTotalNumberComments(channelId));
//        getTotalNumberCommentsNextPage(channelId);
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

    private static String getCommentsAsString(String videoId) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://www.googleapis.com/youtube/v3/commentThreads")
                .queryString("part", "snippet")
                .queryString("videoId", videoId)
                .queryString("fields", "nextPageToken,items(id,snippet(totalReplyCount))")
                .queryString("maxResults", 100)
//                .queryString("pageToken","")
                .queryString("key", myApiKey)
                .asString();
        return response.getBody();
    }

    private static String getCommentsAsStringNextPage(String videoId) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://www.googleapis.com/youtube/v3/commentThreads")
                .queryString("part", "snippet")
                .queryString("videoId", videoId)
                .queryString("fields", "nextPageToken,items(id,snippet(totalReplyCount))")
                .queryString("maxResults", 100)
                .queryString("pageToken","")
                .queryString("key", myApiKey)
                .asString();
        return response.getBody();
    }

    private static CommentsResponse getComments(String videoId) throws UnirestException {
        initApplication();
        HttpResponse<CommentsResponse> response = Unirest.get("https://www.googleapis.com/youtube/v3/commentThreads")
                .queryString("part", "id,snippet")
                .queryString("videoId", videoId)
                .queryString("fields", "nextPageToken,items(id,snippet(totalReplyCount))")
                .queryString("maxResults", 100)
                .queryString("key", myApiKey)
                .asObject(CommentsResponse.class);
        return response.getBody();
    }

    private static CommentsResponse getCommentsNextPage(String videoId,String pageToken) throws UnirestException {
        initApplication();
        HttpResponse<CommentsResponse> response = Unirest.get("https://www.googleapis.com/youtube/v3/commentThreads")
                .queryString("part", "id,snippet")
                .queryString("videoId", videoId)
                .queryString("fields", "nextPageToken,items(id,snippet(totalReplyCount))")
                .queryString("maxResults", 100)
                .queryString("pageToken", pageToken)
                .queryString("key", myApiKey)
                .asObject(CommentsResponse.class);
        return response.getBody();
    }

    private static int getTotalNumberComments(String videoId) throws UnirestException {
        int total = 0;
        String pageToken;
        CommentsResponse commentsResponse = getComments(videoId);
        pageToken = commentsResponse.nextPageToken;

        for (CommentThread i : commentsResponse.items) {
            total++;
            if (i.snippet.totalReplyCount > 0) total += i.snippet.totalReplyCount;
        }

        while (pageToken != null) {
            CommentsResponse commentsResponseNew = getCommentsNextPage(videoId, pageToken);
            pageToken = commentsResponseNew.nextPageToken;
            for (CommentThread i : commentsResponseNew.items) {
                total++;
                if (i.snippet.totalReplyCount > 0) total += i.snippet.totalReplyCount;
            }
        }
        return total;
    }

    private static void getTotalNumberCommentsNextPage(String videoId) throws UnirestException {
        String pageToken;
        CommentsResponse commentsResponse = getComments(videoId);
        pageToken = commentsResponse.nextPageToken;
        commentsResponse.show();

        while (pageToken != null) {
            CommentsResponse commentsResponseNew = getCommentsNextPage(videoId, pageToken);
            pageToken = commentsResponseNew.nextPageToken;
            commentsResponseNew.show();
        }
    }
}