package com.example.fakejsonapipostpractices;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OurRetrofitClient {
    @POST("q")
    Call<PojoClassForResponse> getPostValue(@Body PojoClassForPost pojoClassForPost);
}
