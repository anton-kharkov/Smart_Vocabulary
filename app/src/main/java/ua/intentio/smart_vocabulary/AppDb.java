package ua.intentio.smart_vocabulary;

import android.app.Application;

import ua.intentio.smart_vocabulary.di.components.DaggerDataBaseComponent;
import ua.intentio.smart_vocabulary.di.components.DataBaseComponent;
import ua.intentio.smart_vocabulary.di.module.DataBaseModule;

public class AppDb extends Application {

    private DataBaseComponent dataBaseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        dataBaseComponent = DaggerDataBaseComponent.builder()
                .dataBaseModule(new DataBaseModule(this))
                .build();
    }

    public DataBaseComponent getDataBaseComponent(){
        return dataBaseComponent;
    }
}
