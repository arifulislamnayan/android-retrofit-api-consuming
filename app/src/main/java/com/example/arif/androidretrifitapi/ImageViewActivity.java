package com.example.arif.androidretrifitapi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.arif.androidretrifitapi.model.gitmodel;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class ImageViewActivity extends Activity {
    private ImageView iv;
    private Bitmap bitmap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        iv= (ImageView)findViewById(R.id.imageView);
        //bitmap = getBitmapFromURL("https://avatars.githubusercontent.com/u/10382168?v=3%22");
        //iv.setImageBitmap(bitmap);


        Picasso.with(this)
                .load("https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg")
                .into(iv);
    }

//    public Bitmap getBitmapFromURL(String src) {
//
//
//        try {
//            URL url = new URL(src);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoInput(true);
//            connection.connect();
//            InputStream input = connection.getInputStream();
//            Bitmap myBitmap = BitmapFactory.decodeStream(input);
//            //imgv.setImageBitmap(myBitmap);
//            return myBitmap;
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            return null;
//        }
//
//
//    }

}
