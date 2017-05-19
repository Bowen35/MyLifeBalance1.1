package com.inducesmile.androidmultiquiz;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.inducesmile.androidmultiquiz.database.DBHandler;
import com.inducesmile.androidmultiquiz.entities.Client;
import com.inducesmile.androidmultiquiz.helper.MySharedPreference;

public class SignInActivity extends AppCompatActivity {

    private DBHandler dbh;
    private MySharedPreference sharedPreference;
    private Client client;
    private AutoCompleteTextView emailTV;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#e1c8d6'>My Life Balance | Sign In</font>"));

        dbh = new DBHandler(SignInActivity.this);
        sharedPreference = new MySharedPreference(SignInActivity.this);


        Button signIn = (Button) findViewById(R.id.email_sign_in_button);
        emailTV = (AutoCompleteTextView) findViewById(R.id.email);
        assert signIn != null;
        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                email = emailTV.getText().toString();
                if(email.matches("")){
                    Toast.makeText(SignInActivity.this, "Please enter an email.", Toast.LENGTH_LONG).show();
                }
                if(dbh.checkClient(email)) {
                    sharedPreference.setSessionState(true);
                    Intent quizMenuIntent = new Intent(SignInActivity.this, QuizMenuActivity.class);
                    startActivity(quizMenuIntent);
                }
                else {
                    Toast.makeText(SignInActivity.this, "Email not Registered.", Toast.LENGTH_LONG).show();
                }

            }
        });

        Button register = (Button)findViewById(R.id.register_button);
        assert register != null;
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(SignInActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
    }
}
