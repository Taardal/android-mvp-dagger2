package no.taardal.mvpdaggerexample.module;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import dagger.Module;
import dagger.Provides;
import no.taardal.mvpdaggerexample.api.MovieApi;
import no.taardal.mvpdaggerexample.api.OpenMovieDatabaseApi;
import no.taardal.mvpdaggerexample.api.TheMovieDatabaseApi;
import no.taardal.mvpdaggerexample.qualifier.OMDb;
import no.taardal.mvpdaggerexample.qualifier.TMDb;

@Module
public class ApiModule {

    private RequestQueue requestQueue;

    @Provides
    @TMDb
    MovieApi provideTheMovieDatabaseApi(RequestQueue requestQueue) {
        return new TheMovieDatabaseApi(requestQueue);
    }

    @Provides
    @OMDb
    MovieApi provideOpenMovieDatabaseApi(RequestQueue requestQueue) {
        return new OpenMovieDatabaseApi(requestQueue);
    }

    @Provides
    RequestQueue provideRequestQueue(Context context) {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

}
