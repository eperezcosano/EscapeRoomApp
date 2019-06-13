package edu.upc.dsa.escaperoomapp;

import java.util.List;

import edu.upc.dsa.escaperoomapp.models.Inventario;
import edu.upc.dsa.escaperoomapp.models.Map;
import edu.upc.dsa.escaperoomapp.models.ObjTo;
import edu.upc.dsa.escaperoomapp.models.Objetos;
import edu.upc.dsa.escaperoomapp.models.Profile;
import edu.upc.dsa.escaperoomapp.models.Stats;
import edu.upc.dsa.escaperoomapp.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AuthApi {

    @POST("auth/login")
    Call<User> login(@Body User user);

    @POST("auth/register")
    Call<Void> register(@Body User user);

    @GET("user/statistics/{username}")
    Call<Stats> getStats(@Path("username") String username);

    @GET("user/profile/{username}")
    Call<Profile> getProfile(@Path("username") String username);

    @GET("user/inventory/{username}")
    Call<Inventario> getInventory(@Path("username") String username);

    @POST("user/setWeapon/{username}")
    Call<Void> setWeapon(@Path("username") String username, @Body ObjTo objTo);

    //Android
    @POST("android")
    Call<Void> updateUser(@Body User user);

    @GET("android/map/{id}")
    Call<Map> getMap(@Path("id") int id);

    @POST("android/setinventory")
    Call<Void> setInventory(@Body Inventario inventario);


}