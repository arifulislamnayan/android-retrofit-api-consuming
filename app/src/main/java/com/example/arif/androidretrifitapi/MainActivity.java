package com.example.arif.androidretrifitapi;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.arif.androidretrifitapi.API.gitapi;
import com.example.arif.androidretrifitapi.model.gitmodel;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity {
    private EditText et;
    private TextView tv;
    private Button search;
    private ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.edit);
        tv = (TextView) findViewById(R.id.textView);
        search = (Button) findViewById(R.id.button);
        pbar = (ProgressBar) findViewById(R.id.pb);
        pbar.setVisibility(View.INVISIBLE);


    }
    public void  search(View view)
    {
        String user = et.getText().toString();
        pbar.setVisibility(View.VISIBLE);
        String API = "https://api.github.com";
        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(API).build();
        gitapi git  = restAdapter.create(gitapi.class);


        git.getFeed(user, new Callback<gitmodel>() {
            @Override
            public void success(gitmodel gitmodel, Response response) {
                tv.setText("Github Name :"+gitmodel.getName()+
                        "\nWebsite :"+gitmodel.getBlog()+
                        "\nCompany Name :"+gitmodel.getCompany());
                pbar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void failure(RetrofitError error) {
                tv.setText(error.getMessage());
                pbar.setVisibility(View.INVISIBLE);

            }
        });

    }




}
