package no.taardal.mvpdaggerexample.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import no.taardal.mvpdaggerexample.activity.PlayerActivity;
import no.taardal.mvpdaggerexample.module.ModelModule;
import no.taardal.mvpdaggerexample.module.PresenterModule;
import no.taardal.mvpdaggerexample.module.ViewModule;

@Subcomponent(modules = {
        ViewModule.class,
        PresenterModule.class,
        ModelModule.class
})
public interface PlayerSubComponent extends AndroidInjector<PlayerActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PlayerActivity> {

    }

}
