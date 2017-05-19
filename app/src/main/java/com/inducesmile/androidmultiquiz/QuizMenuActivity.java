package com.inducesmile.androidmultiquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.text.Html;
import android.widget.TextView;

import com.inducesmile.androidmultiquiz.database.DBHandler;
import com.inducesmile.androidmultiquiz.entities.Client;
import com.inducesmile.androidmultiquiz.helper.MySharedPreference;

import java.util.ArrayList;
import java.util.List;

public class QuizMenuActivity extends AppCompatActivity {

    private Button register;
    private Button signIn;
    private Button viewUsers;
    private Button logout;
    private MySharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#e1c8d6'>My Life Balance</font>"));

        Button selectQuiz = (Button)findViewById(R.id.start_quiz_button);
        assert selectQuiz != null;
        selectQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quizCategoryIntent = new Intent(QuizMenuActivity.this, QuizCategoryActivity.class);
                startActivity(quizCategoryIntent);
            }
        });

        Button quizInstruction = (Button)findViewById(R.id.quiz_instruction_button);
        assert quizInstruction != null;
        quizInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instructionIntent = new Intent(QuizMenuActivity.this, QuizInstructionActivity.class);
                startActivity(instructionIntent);
            }
        });

        Button btnBrowse = (Button) findViewById(R.id.btnBrowser);
        btnBrowse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                List<Client> listClients;
                DBHandler dbh = new DBHandler(QuizMenuActivity.this);
                TextView tv = (TextView) findViewById(R.id.textView);
                listClients = new ArrayList<>();
                listClients.clear();
                listClients.addAll(dbh.getAllClient());
                tv.setText(listClients.get(1).getName().toString());
//                Uri webpage = Uri.parse("http://eagles.ic1d.net.au/");
//                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(intent);
//                }
            }
        });

        register = (Button)findViewById(R.id.register_button);
        signIn = (Button)findViewById(R.id.sign_in_button);
        viewUsers = (Button) findViewById(R.id.viewUsers);
        logout = (Button) findViewById(R.id.logout);

        //Hide sign in and register if logged in
        sharedPreference = new MySharedPreference(QuizMenuActivity.this);
        if(sharedPreference.isLoggedIn()) {
            register.setVisibility(View.GONE);
            signIn.setVisibility(View.GONE);
        } else {
            viewUsers.setVisibility(View.GONE);
            logout.setVisibility(View.GONE);
        }

        assert register != null;
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instructionIntent = new Intent(QuizMenuActivity.this, RegisterActivity.class);
                startActivity(instructionIntent);
            }
        });


        assert signIn != null;
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instructionIntent = new Intent(QuizMenuActivity.this, SignInActivity.class);
                startActivity(instructionIntent);
            }
        });

        assert viewUsers != null;
        viewUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ViewUserIntent = new Intent(QuizMenuActivity.this, ViewUsers.class);
                startActivity(ViewUserIntent);
            }
        });

        assert logout != null;
        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                sharedPreference.setSessionState(false);
                Intent instructionIntent = new Intent(QuizMenuActivity.this, SignInActivity.class);
                startActivity(instructionIntent);

            }
        });
    }
}
