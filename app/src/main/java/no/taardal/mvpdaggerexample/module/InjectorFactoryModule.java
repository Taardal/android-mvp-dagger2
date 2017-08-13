package no.taardal.mvpdaggerexample.module;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import no.taardal.mvpdaggerexample.activity.PlayerActivity;
import no.taardal.mvpdaggerexample.activity.TeamActivity;
import no.taardal.mvpdaggerexample.component.PlayerSubComponent;
import no.taardal.mvpdaggerexample.component.TeamSubComponent;

@Module
public abstract class InjectorFactoryModule {

    @Binds
    @IntoMap
    @ActivityKey(TeamActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindTeamActivityInjectorFactory(TeamSubComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(PlayerActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindPlayerActivityInjectorFactory(PlayerSubComponent.Builder builder);

}
