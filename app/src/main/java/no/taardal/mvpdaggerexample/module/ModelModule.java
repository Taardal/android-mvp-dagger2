package no.taardal.mvpdaggerexample.module;

import dagger.Module;
import dagger.Provides;
import no.taardal.mvpdaggerexample.api.MovieApi;
import no.taardal.mvpdaggerexample.model.SearchModel;
import no.taardal.mvpdaggerexample.model.SearchMoviesModel;
import no.taardal.mvpdaggerexample.model.UpcomingModel;
import no.taardal.mvpdaggerexample.model.UpcomingMoviesModel;
import no.taardal.mvpdaggerexample.qualifier.OMDb;
import no.taardal.mvpdaggerexample.qualifier.TMDb;

@Module
public class ModelModule {

    @Provides
    UpcomingModel provideUpcomingModel(@TMDb MovieApi movieApi) {
        return new UpcomingMoviesModel(movieApi);
    }

    @Provides
    SearchModel provideSearchModel(@OMDb MovieApi movieApi) {
        return new SearchMoviesModel(movieApi);
    }

}
