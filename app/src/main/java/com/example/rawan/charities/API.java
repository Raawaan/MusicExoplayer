package com.example.rawan.charities;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rawan on 8/2/18.
 */

public interface API {
    String BASE_URL = "http://demo8044805.mockable.io/";
    @GET("7arka_get_charities")
    Call<ArrayOfObjects> getList();

}
