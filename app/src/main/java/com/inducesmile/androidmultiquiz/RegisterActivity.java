package com.inducesmile.androidmultiquiz;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.inducesmile.androidmultiquiz.database.DBHandler;
import com.inducesmile.androidmultiquiz.database.DatabaseQuery;
import com.inducesmile.androidmultiquiz.entities.Client;

public class RegisterActivity extends AppCompatActivity {

    private AutoCompleteTextView name;
    private AutoCompleteTextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#e1c8d6'>My Life Balance</font>"));

        name = (AutoCompleteTextView) findViewById(R.id.name);
        email = (AutoCompleteTextView) findViewById(R.id.email);

//        Button register = (Button) findViewById(R.id.register_button);
//        assert register != null;
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DBHandler dbHandler = new DBHandler(RegisterActivity.this, null, null, 1);
//                Client client = new Client(name.getText().toString(), email.getText().toString());
//                dbHandler.addClient(client);
//                Intent quizCategoryIntent = new Intent(RegisterActivity.this, QuizMenuActivity.class);
//                startActivity(quizCategoryIntent);
//            }
//        });

        Button asGuest = (Button)findViewById(R.id.guest_button);
        assert asGuest != null;
        asGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quizCategoryIntent = new Intent(RegisterActivity.this, QuizMenuActivity.class);
                startActivity(quizCategoryIntent);
            }
        });
    }

    public void registerClient(View view){
//        DatabaseQuery dbQuery = new DatabaseQuery(RegisterActivity.this);
//        Client client = new Client(name.getText().toString(), email.getText().toString());
//        dbQuery.addClient(client);
//        Intent quizCategoryIntent = new Intent(RegisterActivity.this, QuizMenuActivity.class);
//        startActivity(quizCategoryIntent);

        DBHandler dbHandler = new DBHandler(RegisterActivity.this);
        Client client = new Client(name.getText().toString(), email.getText().toString());
        dbHandler.addClient(RegisterActivity.this, client);
        Intent quizCategoryIntent = new Intent(RegisterActivity.this, QuizMenuActivity.class);
        startActivity(quizCategoryIntent);
    }
}
