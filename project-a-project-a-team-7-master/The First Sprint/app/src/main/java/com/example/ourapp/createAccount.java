package com.example.ourapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class createAccount extends AppCompatActivity {

    private ArrayList<Student> Students;
    private ArrayList<Teacher> Teachers;

    private EditText FirstName;
    private EditText LastName;
    private EditText Email;
    private EditText UserName;
    private EditText Password;
    private EditText ConfirmPassword;
    private RadioGroup rg;
    private RadioButton rb;
    private RadioButton teacher;
    private Button CreateAnAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        FirstName = (EditText) findViewById(R.id.FirstNameET);
        LastName = (EditText) findViewById(R.id.lastNameET);
        Email = (EditText) findViewById(R.id.EmailET);
        UserName = (EditText) findViewById(R.id.UserNameET);
        Password = (EditText) findViewById(R.id.PasswordET);
        ConfirmPassword = (EditText) findViewById(R.id.confirmPasswordET);
        CreateAnAccount = (Button) findViewById(R.id.createAnAccountBN);
        Students = new ArrayList<Student>();
        rg = (RadioGroup)findViewById(R.id.StudentTeacherRB);


        CreateAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                validation(UserName, Password, ConfirmPassword, FirstName, LastName, Email, rg);
            }
        });
    }
    private boolean validateUserName(String username) {
        if ( username.equals(""))
            return false;
        for (int i =0; i<Students.size(); i++)
        {
            if (Students.get(i).getUsername().equals(username))
                return false;
        }
        return true;
    }

    // confirm password
    private boolean validatePassword(String password) {
        if (password.length() < 8 )
            return false;
        else
            return true;
    }

    // confirm that password is equal to confirm password is valid
    private boolean validateConfirmPassword(String confirmPassword, String password) {
        if (confirmPassword.equals(password))
            return true;
        else
            return false;
    }

    // a method that validates all scenarios mentioned previously
    public void validation(EditText usernameET, EditText passwordET, EditText confirmpasswordET, EditText firstName, EditText lastName, EditText email, RadioGroup rg)
    {
        String firstname = firstName.getText().toString();
        String lastname = lastName.getText().toString();
        String Email = email.getText().toString();
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        String confirmpassword = confirmpasswordET.getText().toString();
        int rbID = rg.getCheckedRadioButtonId();

        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        boolean flag5 = true;
        boolean flag6 = true;
        boolean flag7 = true;

        // validating the radio button (student/instructor) username, password and confirm passwords, first name, last name, email

        if (rbID == -1) // if user didn't choose between student and instructor throw a message for them
        {
            Toast.makeText(getApplicationContext(), "you have to click on either student box or the instructor box", Toast.LENGTH_LONG).show();
            flag1 = false;
        }
        if (!validateUserName(username))
        {
            Toast.makeText(getApplicationContext(), "you have to input a valid username", Toast.LENGTH_LONG).show();
            flag2 = false;
        }
        if (!validatePassword(password))
        {
            Toast.makeText(getApplicationContext(), "Invalid password!!!", Toast.LENGTH_LONG).show();
            flag3 = false;
        }
        if (!validateConfirmPassword(confirmpassword, password))
        {
            Toast.makeText(getApplicationContext(), "the confirm password and password are different", Toast.LENGTH_SHORT).show();
            flag4 = false;
        }
        if (firstname.equals(""))
        {
            Toast.makeText(getApplicationContext(), "invalid first name", Toast.LENGTH_SHORT).show();
            flag5 = false;
        }
        if (lastname.equals(""))
        {
            Toast.makeText(getApplicationContext(), "invalid last name", Toast.LENGTH_SHORT).show();
            flag6 = false;
        }
        if (Email.equals(""))
        {
            Toast.makeText(getApplicationContext(), "invalid email", Toast.LENGTH_SHORT).show();
            flag7 = false;
        }
        // if all conditions have been meet send the user congrats and move on to the next activity
        if (flag1 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true && flag6 == true) {
            Toast.makeText(getApplicationContext(), "Congratulations, you have successfully created an account", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, homepage.class);
            startActivity(intent);
        }
    }
}
