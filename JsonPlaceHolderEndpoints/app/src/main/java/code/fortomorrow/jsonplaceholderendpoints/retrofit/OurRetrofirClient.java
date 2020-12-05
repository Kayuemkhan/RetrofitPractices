package code.fortomorrow.jsonplaceholderendpoints.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OurRetrofirClient {
//    @GET("posts")
//    Call<List<POJOClass>> getPosts();
//    @GET("posts/{id}")
//    Call<IdCallData> getposts(@Path("id") int id);
//    @GET("posts/{id}/comments")
//    Call<List<CommentsData>> getPosts(@Path("id") int id);
//    @GET("comments")
//    Call<List<CommentsData>> getPosts(@Query("postId") int id);
    @GET("posts")
    Call<List<POJOClass>> getPosts(@Query("userId") int id);

}
