package no.taardal.mvpdaggerexample.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import no.taardal.mvpdaggerexample.MvpDaggerExampleApplication;
import no.taardal.mvpdaggerexample.component.PlayerSubComponent;
import no.taardal.mvpdaggerexample.component.TeamSubComponent;

@Module(subcomponents = {
        TeamSubComponent.class,
        PlayerSubComponent.class
})
public class AppModule {

    @Provides
    Context provideContext(MvpDaggerExampleApplication mvpDaggerExampleApplication) {
        return mvpDaggerExampleApplication.getApplicationContext();
    }

}
