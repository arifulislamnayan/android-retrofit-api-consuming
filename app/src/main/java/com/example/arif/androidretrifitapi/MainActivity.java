package com.example.arif.androidretrifitapi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arif.androidretrifitapi.API.gitapi;
import com.example.arif.androidretrifitapi.model.gitmodel;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity {
    private EditText et;
    private TextView tv;
    private Button search,loadImage;
    //private ProgressBar pbar;
    private ImageView imgv;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.edit);
        tv = (TextView) findViewById(R.id.textView);
        search = (Button) findViewById(R.id.button);

        //pbar = (ProgressBar) findViewById(R.id.pb);
//        loadImage =(Button) findViewById(R.id.loadImage);
//        loadImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new LoadImage.ex
//            }
//        });

        imgv = (ImageView) findViewById(R.id.imageView2);
//        Picasso.with(this)
//                .load("https://avatars.githubusercontent.com/u/10382168?v=3")
//                .resize(100, 100)
//                .into(imgv);


        //bitmap = getBitmapFromURL("https://avatars.githubusercontent.com/u/10382168?v=3");
        //imgv.setImageBitmap(bitmap);


    }
//    public Bitmap getBitmapFromURL(String src) {
//
//
//            try {
//                URL url = new URL(src);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setDoInput(true);
//                connection.connect();
//                InputStream input = connection.getInputStream();
//                Bitmap myBitmap = BitmapFactory.decodeStream(input);
//                //imgv.setImageBitmap(myBitmap);
//                return myBitmap;
//
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace();
//                return null;
//            }
//
//
//        }


    public void  search(View view)
    {
        String user = et.getText().toString();
        //pbar.setVisibility(View.VISIBLE);
        String API = "https://api.github.com";
        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(API).build();
        gitapi git  = restAdapter.create(gitapi.class);


        git.getFeed(user, new Callback<gitmodel>() {
            @Override
            public void success(gitmodel gitmodel, Response response) {
                tv.setText("Github Name :" + gitmodel.getName() +
                        "\nWebsite :" + gitmodel.getBlog() +
                        "\nCompany Name :" + gitmodel.getCompany() +
                        "\nLocation:" + gitmodel.getLocation()+
                         "\nEmail:" + gitmodel.getEmail());;

                Picasso.with(getApplicationContext())
                        .load(gitmodel.getAvatarUrl())

                        .into(imgv);




//                bitmap = getBitmapFromURL("https://avatars.githubusercontent.com/u/10382168?v=3");
//                imgv.setImageBitmap(bitmap);

                //pbar.setVisibility(View.INVISIBLE);
//
//                String imageUrl= gitmodel.getAvatarUrl();
//
//                //Toast.makeText(getApplicationContext(),imageUrl,Toast.LENGTH_LONG).show();
//
//                try {
//                    URL url = new URL(imageUrl);
//                    try {
//                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                        connection.setDoInput(true);
//                        connection.connect();
//                        InputStream input = connection.getErrorStream();
//                        Bitmap myBitmap = BitmapFactory.decodeStream(input);
//                        imgv.setImageBitmap(myBitmap);
//
//                    }
//                    catch (IOException e)
//                    {
//                        e.getMessage();
//                    }
//
//
//                }
//                catch (MalformedURLException e)
//                {
//                    e.getMessage();
//                }


            }

            @Override
            public void failure(RetrofitError error) {
                tv.setText(error.getMessage());
                //String uri = "@drawable/not_found.png";

                imgv.setImageDrawable(getResources().getDrawable(R.drawable.nf));
                //pbar.setVisibility(View.INVISIBLE);

            }
        });

    }
//    public void go(View view)
//    {
//        Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
//        startActivity(intent);
//    }




}
