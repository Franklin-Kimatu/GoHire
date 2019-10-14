package com.moringa.gohire;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringa.gohire.Constants.ACCESS_TOKEN;
import static com.moringa.gohire.Constants.BASE_URL;

public class    ScorersClient {
    private static Retrofit retrofit = null;

    public static ScorersApi getHttpClient(){
        if (retrofit == null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request  newRequest = chain.request().newBuilder()
                                    .addHeader("X-Auth-Token",ACCESS_TOKEN)
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ScorersApi.class);
    }
}
