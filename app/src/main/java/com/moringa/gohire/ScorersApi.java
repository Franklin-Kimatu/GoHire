package com.moringa.gohire;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ScorersApi {

    @GET("competitions/{id}/scorers")
    Call<ScorersResponse> getScorers(@Path("id") String yearId);
}
