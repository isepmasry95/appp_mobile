package fr.patrickwang.androidappdemo.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by patrick on 12/10/2017.
 * Class for Comment resources.
 */

public class Comment implements Response {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public Comment() {
    }

    public Comment(Parcel in) {
        this.postId = in.readInt();
        this.id = in.readInt();
        this.name = in.readString();
        this.email = in.readString();
        this.body = in.readString();
    }

    @Override
    public void initialiseWithJson(JSONObject jsonObject) throws JSONException {
        int postId = jsonObject.getInt(POST_ID);
        int id = jsonObject.getInt(ID);
        String name = jsonObject.getString(NAME);
        String email = jsonObject.getString(EMAIL);
        String body = jsonObject.getString(BODY);

        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    @Override
    public HashMap<String, String> getDetails() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(POST_ID, String.valueOf(postId));
        hashMap.put(ID, String.valueOf(id));
        hashMap.put(NAME, name);
        hashMap.put(EMAIL, email);
        hashMap.put(BODY, body);
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
        parcel.writeInt(postId);
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(body);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };

    //region Getters and setters
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    //endregion
}
