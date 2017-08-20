package no.taardal.mvpdaggerexample.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import no.taardal.mvpdaggerexample.mvpmodel.MovieModel;
import no.taardal.mvpdaggerexample.mvpmodel.OpenMovieDatabaseModel;
import no.taardal.mvpdaggerexample.mvpmodel.TheMovieDatabaseModel;
import no.taardal.mvpdaggerexample.qualifier.OMDb;
import no.taardal.mvpdaggerexample.qualifier.TMDb;

@Module
public class ModelModule {

    @Provides
    @TMDb
    MovieModel provideTheMovieDatabaseModel(Context context) {
        return new TheMovieDatabaseModel(context);
    }

    @Provides
    @OMDb
    MovieModel provideOpenMovieDatabaseModel(Context context) {
        return new OpenMovieDatabaseModel(context);
    }

}
