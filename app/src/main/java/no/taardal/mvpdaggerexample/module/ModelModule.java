package no.taardal.mvpdaggerexample.module;

import dagger.Module;
import dagger.Provides;
import no.taardal.mvpdaggerexample.api.MovieApi;
import no.taardal.mvpdaggerexample.mvpmodel.SearchModel;
import no.taardal.mvpdaggerexample.mvpmodel.SearchMoviesModel;
import no.taardal.mvpdaggerexample.mvpmodel.UpcomingModel;
import no.taardal.mvpdaggerexample.mvpmodel.UpcomingMoviesModel;
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
