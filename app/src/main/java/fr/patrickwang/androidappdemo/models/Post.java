package fr.patrickwang.androidappdemo.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by patrick on 12/10/2017.
 * Class for Post resources.
 */

public class Post implements Response {
    private int userId;
    private int id;
    private String title;
    private String body;

    public Post() {
    }

    @Override
    public void initialiseWithJson(JSONObject jsonObject) throws JSONException {
        int userId = jsonObject.getInt(USER_ID);
        int id = jsonObject.getInt(ID);
        String title = jsonObject.getString(TITLE);
        String body = jsonObject.getString(BODY);

        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public HashMap<String, String> getDetails() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(USER_ID, String.valueOf(userId));
        hashMap.put(ID, String.valueOf(id));
        hashMap.put(TITLE, title);
        hashMap.put(BODY, body);
        return hashMap;
    }

    public Post(Parcel in) {
        this.userId = in.readInt();
        this.id = in.readInt();
        this.title = in.readString();
        this.body = in.readString();
    }

    @Override
    public String getName() {
        return this.title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(userId);
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(body);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    //region Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    //endregion
}
