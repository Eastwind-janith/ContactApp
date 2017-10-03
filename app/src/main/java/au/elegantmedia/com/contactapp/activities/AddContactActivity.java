package au.elegantmedia.com.contactapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import au.elegantmedia.com.contactapp.R;
import au.elegantmedia.com.contactapp.helpers.Helper;
import au.elegantmedia.com.contactapp.models.Contact;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

public class AddContactActivity extends AppCompatActivity {

    private static final int PICK_IMAG = 99;
    private static final int MEDIA_IMAGE = 4;
    @BindView(R.id.et_name)
    EditText mName;
    @BindView(R.id.et_email)
    EditText mEmail;
    @BindView(R.id.et_phone)
    EditText mPhone;
    @BindView(R.id.contact_img)
    ImageButton imageButton;

    Helper helper;
    Uri resultUri;
    Realm realm;

    @OnClick(R.id.btn_save)
    public void saveContact() {
//        if (isformValidet() && new Helper().isPhoneNumberValidat(mPhone)) {

        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        //contact.setImage(String.valueOf(resultUri));
        Contact contact = realm.createObject(Contact.class);
        contact.setName(mName.getText().toString().trim());
        contact.setEmail(mEmail.getText().toString().trim());
        contact.setPhone(mPhone.getText().toString().trim());

        realm.commitTransaction();

//            helper.clearEditText(mEmail);
//            helper.clearEditText(mPhone);
//            helper.clearEditText(mName);


//        }
    }

    @OnClick(R.id.contact_img)
    public void Image() {

        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        Uri media = getMediaFile(MEDIA_IMAGE);
        galleryIntent.putExtra(MediaStore.EXTRA_OUTPUT, media);
        galleryIntent.setType("image/*");
        startActivityForResult(Intent.createChooser(galleryIntent, "Select Picture"), PICK_IMAG);
    }

    @OnClick(R.id.btn_cancel)
    public void cancel() {
        startActivity(new Intent(this, MainActivity.class));
//        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        ButterKnife.bind(this);
    }


    private boolean isformValidet() {
        helper = new Helper();
        if (helper.isEmptyEditText(mName, "Name required") &&
                helper.isEmptyEditText(mEmail, "Email required") &&
                helper.isEmptyEditText(mPhone, "Phone required")) {
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAG && resultCode == RESULT_OK) {

            resultUri = data.getData();
            Log.wtf("tag", String.valueOf(resultUri));
            Picasso.with(this).load(resultUri).resize(400, 400).centerCrop().into(imageButton);
//            Uri media = getMediaFile(MEDIA_IMAGE);
//            intent.putExtra(MediaStore.EXTRA_OUTPUT,media);

        }
    }

    private Uri getMediaFile(int mediaImage) {

        if (isExtenalStorage()) {
            //get URI
            File mediaStorageDir = getExternalFilesDir("NEW PHOTO");

            String fileName = "";
            String fileType = "";
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            if (mediaImage == MEDIA_IMAGE) {
                fileName = "IMG_" + timeStamp;
                fileType = ".jpg";
            } else {
                return null;
            }

            File mediaFile;
            try {
                mediaFile = File.createTempFile(fileName, fileType, mediaStorageDir);
                //Log.i(TAG, "File" + mediaFile.toString());
                //put Path to sharedPreferences

                return Uri.fromFile(mediaFile);
            } catch (IOException e) {
                // Log.i(TAG, " error " + mediaStorageDir.getAbsolutePath() + fileName + fileType);
            }
        }
        return null;
    }

    private boolean isExtenalStorage() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        } else {
            return false;
        }
    }
}
