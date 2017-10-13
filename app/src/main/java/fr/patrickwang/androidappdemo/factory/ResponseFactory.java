package fr.patrickwang.androidappdemo.factory;

import android.os.Parcel;

import fr.patrickwang.androidappdemo.models.*;


/**
 * Created by patrick on 12/10/2017.
 * Standard implementation of the Factory design pattern
 */
public class ResponseFactory {
    public Response create(String type) {
        switch (type) {
            case "posts":
                return new Post();
            case "comments":
                return new Comment();
            case "albums":
                return new Album();
            case "todos":
                return new Todo();
            case "users":
                return new User();
            default:
                throw new IllegalArgumentException("Unknown resource of type " + type);
        }
    }

    public Response create(String type, Parcel in) {
        switch (type) {
            case "posts":
                return new Post(in);
            case "comments":
                return new Comment(in);
            case "albums":
                return new Album(in);
            case "todos":
                return new Todo(in);
            case "users":
                return new User(in);
            default:
                throw new IllegalArgumentException("Unknown resource of type " + type);
        }
    }
}
