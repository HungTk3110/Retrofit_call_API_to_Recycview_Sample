package com.example.retrofitandroid_sample.API;

import com.example.retrofitandroid_sample.model.Currency;
import com.example.retrofitandroid_sample.model.Post;
import com.example.retrofitandroid_sample.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    // link api: http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
    // https://jsonplaceholder.typicode.com/posts

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiService apiService = new Retrofit.Builder()
            //.baseUrl("http://apilayer.net/api/")
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

//    @GET("api/live")
//    Call<Currency> call(@Query("access_key")String access_key ,
//                        @Query("currencies") String currencies ,
//                        @Query("source") String source ,
//                        @Query("format") int format);

    @GET("api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1")
    Call<Currency> call();


    @POST("posts")
    Call<Post> sendPost(@Body Post post);

    @GET("posts")
    Call<List<User>> getListUser(@Query("userId") int userID);
}
