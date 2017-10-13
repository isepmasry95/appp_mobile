package fr.patrickwang.androidappdemo.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by patrick on 12/10/2017.
 * Class for Todo resources.
 */

public class Todo implements Response {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todo() {
    }

    public Todo(Parcel in) {
        this.userId = in.readInt();
        this.id = in.readInt();
        this.title = in.readString();
        this.completed = in.readByte() != 0;
    }

    @Override
    public void initialiseWithJson(JSONObject jsonObject) throws JSONException {
        int userId = jsonObject.getInt(USER_ID);
        int id = jsonObject.getInt(ID);
        String title = jsonObject.getString(TITLE);
        boolean completed = jsonObject.getBoolean(COMPLETED);

        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    @Override
    public HashMap<String, String> getDetails() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(USER_ID, String.valueOf(userId));
        hashMap.put(ID, String.valueOf(id));
        hashMap.put(TITLE, title);
        hashMap.put(COMPLETED, String.valueOf(completed));
        return hashMap;
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
        parcel.writeInt(this.userId);
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeByte((byte) (this.completed ? 1 : 0));
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Todo createFromParcel(Parcel in) {
            return new Todo(in);
        }

        public Todo[] newArray(int size) {
            return new Todo[size];
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    //endregion
}
