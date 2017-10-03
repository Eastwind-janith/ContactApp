package au.elegantmedia.com.contactapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import au.elegantmedia.com.contactapp.R;
import au.elegantmedia.com.contactapp.adapters.ContactAdapter;
import au.elegantmedia.com.contactapp.models.Contact;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tag";

//    @BindView(R.id.recycleview)
//    RecyclerView mRecyclerView;

    RecyclerView.Adapter adapter;
    List<Contact> contactList;
    Realm realm;
    Contact contact;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
        // Realm.init(this);


        Realm realm = Realm.getDefaultInstance();
//        realm.beginTransaction();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactList = new ArrayList<>();

        final RealmResults<Contact> results = realm.where(Contact.class).findAll();

        for (int i = 0; i < results.size(); i++) {
            contact = new Contact(results.get(i).getName().toString(),
                    results.get(i).getEmail().toString(),
                    results.get(i).getPhone().toString()
                    /*results.get(i).getImage().toString()*/);
            contactList.add(contact);
            Log.i(TAG, results.get(i).getName());

        }

        adapter = new ContactAdapter(contactList, getApplicationContext());
        mRecyclerView.setAdapter(adapter);

        Log.i(TAG, "" + results);
        Log.i(TAG, "" + contactList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_contact) {
            startActivity(new Intent(this, AddContactActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
