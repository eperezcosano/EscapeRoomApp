package edu.upc.dsa.escaperoomapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AuthApi {

    @POST("users")//TODO: auth/login
    Call<User> login(@Body User user);

    @POST("users")//TODO: auth/register
    Call<User> register(@Body User user);

}