package fr.patrickwang.androidappdemo.models;

import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by patrick on 12/10/2017.
 * Interface which represents the generic resources available through the web service
 */
public interface Response extends Parcelable {
    String USER_ID = "userId";
    String ID = "id";
    String TITLE = "title";
    String BODY = "body";
    String POST_ID = "postId";
    String NAME = "name";
    String EMAIL = "email";
    String COMPLETED = "completed";
    String USERNAME = "username";
    String PHONE = "phone";
    String WEBSITE = "website";

    /**
     * Generic method to initialize a Response object with a JSONObject
     * @param jsonObject A JSONObject containing values for each attribute of a Response
     * @throws JSONException Exception for when the JSONObject does not correspond exactly to a Reponse
     */
    void initialiseWithJson(JSONObject jsonObject) throws JSONException;

    /**
     * Generic method to get the detailed information of a Response object
     * @return A map of the parameters of a Response object
     */
    HashMap<String, String> getDetails();

    /**
     * Generic method to get the name or title of a Response object
     * @return The name or title of a Response object
     */
    String getName();
}
