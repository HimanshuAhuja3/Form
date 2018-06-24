package com.example.himanshuahuja.formfilling;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText firstnameEdittext, lastnameEdittext, emailEdittext, passEdittext, passAgainEdittext, birthdayEdittext;
    public static final String SHARED_PREFS = " sharedPrefs";
    RadioGroup genderRadioGroup;
    Button registerButton;
    DatePickerDialog datePickerDialog;
    String firstname, lastname;
    String gender;
    String email;
    String pass;
    String passAgain;
    String birthday;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindViews();


        setViewActions();

        prepareDatePickerDialog();

    }

    public void bindViews() {
        firstnameEdittext = (EditText) findViewById(R.id.firstname_edittext);
        lastnameEdittext = (EditText) findViewById(R.id.lastname_edittext);
        emailEdittext = (EditText) findViewById(R.id.email_edittext);
        passEdittext = (EditText) findViewById(R.id.password_edittext);
        passAgainEdittext = (EditText) findViewById(R.id.password_again_edittext);
        birthdayEdittext = (EditText) findViewById(R.id.birthday_edittext);
        genderRadioGroup = (RadioGroup) findViewById(R.id.gender_radiogroup);
        registerButton = (Button) findViewById(R.id.register_button);
    }

    private void setViewActions() {
        birthdayEdittext.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    private void prepareDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                birthdayEdittext.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                datePickerDialog.dismiss();
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }

    public void showToastWithFormValues() {


        firstname = firstnameEdittext.getText().toString();

        lastname = lastnameEdittext.getText().toString();
        email = emailEdittext.getText().toString();
        pass = passEdittext.getText().toString();
        passAgain = passAgainEdittext.getText().toString();
        birthday = birthdayEdittext.getText().toString();


        RadioButton selectedRadioButton = (RadioButton) findViewById(genderRadioGroup.getCheckedRadioButtonId());
        gender = selectedRadioButton == null ? "" : selectedRadioButton.getText().toString();
        if (!firstname.equals("") && !lastname.equals("") && !email.equals("") && !pass.equals("") && !passAgain.equals("") && !birthday.equals("") && !gender.equals("")) {


            if (pass.equals(passAgain)) {


                Toast.makeText(this, getResources().getString(R.string.here_is_values, ("\nFirstname:" + firstname + "\nLastname:" + lastname + "\nEmail:" + email + "\nBirthday:" + birthday + "\nGender:" + gender)), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getResources().getString(R.string.passwords_must_be_the_same), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, getResources().getString(R.string.no_field_can_be_empty), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.birthday_edittext:
                datePickerDialog.show();
                break;
            case R.id.register_button:


                showToastWithFormValues();
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("Firstname", firstname);
                intent.putExtra("Lastname", lastname);
                intent.putExtra("maile", email);
                intent.putExtra("DOB", birthday);
                intent.putExtra("Gender", gender);
                startActivity(intent);
                break;
        }


    }



}
