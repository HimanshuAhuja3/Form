package com.example.himanshuahuja.formfilling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle bundle=getIntent().getExtras();
       String FirstName=bundle.getString("Firstname");
        String LastName=bundle.getString("Lastname");
        String Email=bundle.getString("maile");
        String DateOfBirth=bundle.getString("DOB");
        String Gender=bundle.getString("Gender");

        TextView first= findViewById(R.id.finame);
        first.setText("FirstName:"+FirstName);
        TextView last= findViewById(R.id.lastname);
        last.setText("LastName:"+LastName);
        TextView E_mail= findViewById(R.id.mail);
        E_mail.setText("Email:"+Email);
        TextView DOB= findViewById(R.id.dob);
        DOB.setText("DOB:"+DateOfBirth);
        TextView sex= findViewById(R.id.gender);
        sex.setText("Sex:"+Gender);







    }

}
