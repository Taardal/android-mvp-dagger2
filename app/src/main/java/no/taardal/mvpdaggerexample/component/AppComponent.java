package no.taardal.mvpdaggerexample.component;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import no.taardal.mvpdaggerexample.MvpDaggerExampleApplication;
import no.taardal.mvpdaggerexample.module.AndroidInjectorModule;
import no.taardal.mvpdaggerexample.module.AppModule;

@Component(modules = {
        AndroidSupportInjectionModule.class,
        AndroidInjectorModule.class,
        AppModule.class
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
