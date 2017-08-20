package no.taardal.mvpdaggerexample.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import no.taardal.mvpdaggerexample.MvpDaggerExampleApplication;

@Module
public class AppModule {

    @Provides
    Context provideContext(MvpDaggerExampleApplication mvpDaggerExampleApplication) {
        return mvpDaggerExampleApplication.getApplicationContext();
    }

}
