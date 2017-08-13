package no.taardal.mvpdaggerexample.component;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import no.taardal.mvpdaggerexample.MvpDaggerExampleApplication;
import no.taardal.mvpdaggerexample.module.AppModule;
import no.taardal.mvpdaggerexample.module.InjectorFactoryModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        InjectorFactoryModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(MvpDaggerExampleApplication mvpDiExampleApplication);

        AppComponent build();

    }

    void inject(MvpDaggerExampleApplication mvpDiExampleApplication);

}
