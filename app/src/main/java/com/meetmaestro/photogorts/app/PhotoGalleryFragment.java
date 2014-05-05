package com.meetmaestro.photogorts.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meetmaestro.photogorts.model.Photo;
import com.meetmaestro.photogorts.sdk.GortPhotoService;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Fragment containing the interface for viewing photos.
 *
 * Created by joshuakovach on 5/1/14.
 */
public class PhotoGalleryFragment extends Fragment implements Callback<List<Photo>> {
    private RestAdapter restAdapter;
    private GortPhotoService service;
    protected View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_photo_gallery, container, false);

        restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://android-dev-photobucket.herokuapp.com")
                .build();
        service = restAdapter.create(GortPhotoService.class);

        return rootView;
    }

    @Override
    public void onResume() {
        service.listPhotos(this);
    }

    @Override
    public void success(List<Photo> photos, Response response) {
        for (Photo p : photos) {
            Log.i("PHOTO", p.toString());
        }
    }

    @Override
    public void failure(RetrofitError error) {
        Log.i("PHOTO PROBLEM", error.toString());
    }
}

