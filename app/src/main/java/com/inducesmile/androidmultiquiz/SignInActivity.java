package com.inducesmile.androidmultiquiz;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

import com.inducesmile.androidmultiquiz.database.DBHandler;
import com.inducesmile.androidmultiquiz.entities.Client;
import com.inducesmile.androidmultiquiz.helper.MySharedPreference;

public class SignInActivity extends AppCompatActivity {

    private DBHandler dbh = new DBHandler(SignInActivity.this);
    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#e1c8d6'>My Life Balance | Sign In</font>"));

        client = new Client("Jeremy", "some@one.com");
        dbh.addClient(client);
        MySharedPreference sharedPreference = new MySharedPreference(SignInActivity.this);
        sharedPreference.setSessionState(true);

//        Button signIn = (Button) findViewById(R.id.sign_in_button);
//        assert signIn != null;
//        signIn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                //if email exists then menu
//                //else toast no email
//            }
//        });

        Button register = (Button)findViewById(R.id.register_button);
        assert register != null;
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quizCategoryIntent = new Intent(SignInActivity.this, RegisterActivity.class);
                startActivity(quizCategoryIntent);
            }
        });
    }
}
