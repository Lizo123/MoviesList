package com.example.theportalagency_task.MovieProfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.theportalagency_task.Models.MovieModel;
import com.example.theportalagency_task.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.release_date)
    TextView release_date;

    MovieModel movieModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        if(getIntent().getExtras()!=null)
        {
            movieModel= getIntent().getParcelableExtra("movie");
        }
        Glide.with(this).load("https://image.tmdb.org/t/p/w500"+movieModel.getPoster_path()).into(image);


        title.setText(movieModel.getTitle());
        description.setText(movieModel.getOverview());
        release_date.setText(movieModel.getRelease_date());


    }
}
