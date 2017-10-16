package com.example.noxusfrosted.lazyinstagram.api;

import com.example.noxusfrosted.lazyinstagram.model.UserProfile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String BASE = "https://us-central1-retrofit-course.cloudfunctions.net";
    @GET("/getProfile")
    Call<UserProfile> getProfile(@Query("user") String user);
}