package no.taardal.mvpdaggerexample.module;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import no.taardal.mvpdaggerexample.api.MovieApi;
import no.taardal.mvpdaggerexample.api.OpenMovieDatabaseApi;
import no.taardal.mvpdaggerexample.api.TheMovieDatabaseApi;
import no.taardal.mvpdaggerexample.qualifier.OMDb;
import no.taardal.mvpdaggerexample.qualifier.TMDb;

@Module
public class ApiModule {

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
    @Singleton
    RequestQueue provideRequestQueue(Context context) {
        return Volley.newRequestQueue(context);
    }

}
