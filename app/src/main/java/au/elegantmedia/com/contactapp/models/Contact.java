package au.elegantmedia.com.contactapp.models;

import io.realm.RealmObject;

/**
 * Created by Devinda on 9/25/17.
 */

public class Contact extends RealmObject{
    String image;
    String name;
    String email;
    String phone;

    public Contact() {
    }

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Contact(String image, String name, String email, String phone) {
        this.image = image;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
