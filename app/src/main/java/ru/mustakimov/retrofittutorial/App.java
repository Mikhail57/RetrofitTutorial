package ru.mustakimov.retrofittutorial;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mustakimov.retrofittutorial.api.UmoriliApi;

/**
 * Created by misha on 31.10.2016.
 */

public class App extends Application {

    private static UmoriliApi umoriliApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://umorili.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        umoriliApi = retrofit.create(UmoriliApi.class);
    }

    public static UmoriliApi getApi() {
        return umoriliApi;
    }
}
