package edu.upc.dsa.escaperoomapp;

import edu.upc.dsa.escaperoomapp.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthApi {

    @POST("auth/login")
    Call<User> login(@Body User user);

    @POST("auth/register")
    Call<Void> register(@Body User user);

}