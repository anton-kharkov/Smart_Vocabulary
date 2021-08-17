package ua.intentio.smart_vocabulary.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ua.intentio.smart_vocabulary.AddWordActivity;
import ua.intentio.smart_vocabulary.di.module.DataBaseModule;

@Singleton
@Component(modules = DataBaseModule.class)
public interface DataBaseComponent {

    void inject(AddWordActivity addWordActivity);
}
