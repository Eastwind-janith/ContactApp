package au.elegantmedia.com.contactapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;

/**
 * Created by Devinda on 9/25/17.
 */

public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initial();
    }

    private void initial() {

    }
}
