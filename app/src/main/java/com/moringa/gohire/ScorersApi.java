package com.moringa.gohire;

import com.moringa.gohire.models.ScorersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ScorersApi {

    @GET("competitions/{id}/scorers")
    Call<ScorersResponse> getScorers(@Path("id") String yearId);
}
