package com.example.imagesliderapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class ImageFragment extends Fragment {
    private static final String TAG = "ImageFragment";
    private ImageView image;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        image=view.findViewById(R.id.cityImage);
        Bundle bundle = getArguments();

        if(null!=bundle){

            String url = bundle.getString("ImageUrl","");
            Glide.with(getActivity()).asBitmap().load(url).into(image);
        }

        return view;
    }
}
