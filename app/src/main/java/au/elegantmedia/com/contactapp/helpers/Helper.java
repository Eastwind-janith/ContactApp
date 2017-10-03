package au.elegantmedia.com.contactapp.helpers;

import android.widget.EditText;

/**
 * Created by Devinda on 9/25/17.
 */

public class Helper {

    public static boolean isEmptyEditText(EditText editText, String massege) {

        if (editText.getText().toString().trim().isEmpty()) {
            editText.setError(massege);
            editText.requestFocus();
            return true;
        }
        return false;
    }

    public void clearEditText(EditText editText) {

        editText.setText("");

    }

    public boolean isPhoneNumberValidat(EditText editText) {

        if (editText.getText().toString().trim().length() == 10) {
            return true;
        }
        return false;
    }

}
