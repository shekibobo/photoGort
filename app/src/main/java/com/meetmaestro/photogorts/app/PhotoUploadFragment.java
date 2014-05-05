package com.meetmaestro.photogorts.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A Fragment containing the interface for uploading a photo.
 *
 * Created by joshuakovach on 5/1/14.
 */
public class PhotoUploadFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_photo_upload, container, false);
        ImageButton uploadButton = (ImageButton) rootView.findViewById(R.id.upload_button);

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBackgroundColor((View) view.getParent());
            }
        });

        return rootView;
    }

    private void changeBackgroundColor(View view) {
        view.setBackgroundColor(Color.BLUE);
    }
}

