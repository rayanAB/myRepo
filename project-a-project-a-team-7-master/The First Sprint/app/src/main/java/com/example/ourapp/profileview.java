package com.example.ourapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class profileview extends AppCompatActivity {

    TextView username, firstname,lastname,experiencepoints,bio ;
    private CircleImageView profile_pic;

    String user,first,last,exp,bi;

    Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileview);

        edit = (Button) findViewById(R.id.EditButton);

        username = findViewById(R.id.UsernameView);
        firstname = findViewById(R.id.FirstnameView);
        lastname = findViewById(R.id.LastNameView);
        experiencepoints = findViewById(R.id.ExpPtsView);
        bio = findViewById(R.id.BioView);

        profile_pic = (CircleImageView)findViewById(R.id.pic);

    }





    public void editprofile(View v){
        Intent i = new Intent(getApplicationContext(),profileedit.class);
        i.putExtra("username",username.getText().toString());
        i.putExtra("firstname",firstname.getText().toString());
        i.putExtra("lastname",lastname.getText().toString());
        i.putExtra("exppoints",experiencepoints.getText().toString());
        i.putExtra("bio",bio.getText().toString());
        startActivityForResult(i,1);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            if(resultCode==RESULT_OK){
                username = findViewById(R.id.UsernameView);
                firstname = findViewById(R.id.FirstnameView);
                lastname = findViewById(R.id.LastNameView);
                experiencepoints = findViewById(R.id.ExpPtsView);
                bio = findViewById(R.id.BioView);


                user = data.getStringExtra("user");
                first = data.getStringExtra("first");
                last = data.getStringExtra("last");
                exp = data.getStringExtra("exp");
                bi = data.getStringExtra("bi");

                username.setText(user);
                firstname.setText(first);
                lastname.setText(last);
                experiencepoints.setText(exp);
                bio.setText(bi);

            }
            if (resultCode==RESULT_CANCELED){
                Toast.makeText(getApplicationContext(),"there was an error",Toast.LENGTH_LONG).show();
            }
        }


    }
}
