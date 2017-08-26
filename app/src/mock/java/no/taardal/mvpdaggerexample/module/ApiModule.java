package no.taardal.mvpdaggerexample.module;

import dagger.Module;
import dagger.Provides;
import no.taardal.mvpdaggerexample.api.MovieApi;
import no.taardal.mvpdaggerexample.api.OpenMovieDatabaseApiMock;
import no.taardal.mvpdaggerexample.api.TheMovieDatabaseApiMock;
import no.taardal.mvpdaggerexample.qualifier.OMDb;
import no.taardal.mvpdaggerexample.qualifier.TMDb;

@Module
public class ApiModule {

    @Provides
    @TMDb
    MovieApi provideTheMovieDatabaseApi() {
        return new TheMovieDatabaseApiMock();
    }

    @Provides
    @OMDb
    MovieApi provideOpenMovieDatabaseApi() {
        return new OpenMovieDatabaseApiMock();
    }

}
