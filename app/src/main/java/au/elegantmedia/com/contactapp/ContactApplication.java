package au.elegantmedia.com.contactapp;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Devinda on 9/25/17.
 */

public class ContactApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
//        RealmConfiguration config = new RealmConfiguration.Builder().name("contact.realm").build();
//        Realm.setDefaultConfiguration(config);
    }
}
