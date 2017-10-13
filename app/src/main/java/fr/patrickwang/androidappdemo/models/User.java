package fr.patrickwang.androidappdemo.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by patrick on 12/10/2017.
 * Class for User resources.
 */

public class User implements Response {
    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    public User() {
    }

    public User(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.username = in.readString();
        this.email = in.readString();
        this.phone = in.readString();
        this.website = in.readString();
    }

    @Override
    public void initialiseWithJson(JSONObject jsonObject) throws JSONException {
        int id = jsonObject.getInt(ID);
        String name = jsonObject.getString(NAME);
        String username = jsonObject.getString(USERNAME);
        String email = jsonObject.getString(EMAIL);
        String phone = jsonObject.getString(PHONE);
        String website = jsonObject.getString(WEBSITE);

        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    @Override
    public HashMap<String, String> getDetails() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ID, String.valueOf(id));
        hashMap.put(NAME, name);
        hashMap.put(USERNAME, username);
        hashMap.put(EMAIL, email);
        hashMap.put(PHONE, phone);
        hashMap.put(WEBSITE, website);
        return hashMap;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.username);
        parcel.writeString(this.email);
        parcel.writeString(this.phone);
        parcel.writeString(website);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    //region Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    //endregion
}
