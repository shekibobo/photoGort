package com.meetmaestro.photogorts.sdk;

import com.meetmaestro.photogorts.model.Photo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by joshuakovach on 5/5/14.
 */
public interface GortPhotoService {
    @GET("/api/v1/photos")
    void listPhotos(Callback<List<Photo>> callback);
}
