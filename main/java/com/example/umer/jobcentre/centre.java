package com.example.umer.jobcentre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by umer on 11/28/2017.
 */


    public class centre extends AppCompatActivity {
//savt

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;
    private Button buttonLogout;

    private TextView sert;
        private ImageView serm;
    private TextView sett;
    private ImageView setm;

    private TextView savet;
    private ImageView savem;
    private TextView abtt;
    private ImageView abtm;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_centre);
            //initializing firebase authentication object
            firebaseAuth = FirebaseAuth.getInstance();

            //if the user is not logged in
            //that means current user will return null
            if(firebaseAuth.getCurrentUser() == null){
                //closing this activity
                finish();
                //starting login activity
                startActivity(new Intent(this, LoginActivity.class));
            }

            //getting current user
            FirebaseUser user = firebaseAuth.getCurrentUser();

            //initializing views
            textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
            buttonLogout = (Button) findViewById(R.id.buttonLogout);

            //displaying logged in user name
            textViewUserEmail.setText("Welcome "+user.getEmail());

            //adding listener to button
           // buttonLogout.setOnClickListener((View.OnClickListener) this);
            buttonLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //logging out the user
                    firebaseAuth.signOut();
                    //closing activity
                    finish();
                    //starting login activity
                  //  startActivity(new Intent(this, LoginActivity.class));
                    Intent i= new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);

                }
            });

            savet=(TextView) findViewById(R.id.savt);
            savet.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i= new Intent(getApplicationContext(),ProfileActivity.class);
                                             startActivity(i);
                                         }
                                     }

            );

            savem=(ImageView) findViewById(R.id.savm);
            savem.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i= new Intent(getApplicationContext(),ProfileActivity.class);
                                             startActivity(i);
                                         }
                                     }

            );


            abtt=(TextView) findViewById(R.id.abtt);
            abtt.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i= new Intent(getApplicationContext(),About.class);
                                             startActivity(i);
                                         }
                                     }

            );

            abtm=(ImageView) findViewById(R.id.abtm);
            abtm.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i= new Intent(getApplicationContext(),About.class);
                                             startActivity(i);
                                         }
                                     }

            );
//////////////

        sert=(TextView) findViewById(R.id.sert);
        sert.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         Intent i= new Intent(getApplicationContext(),search.class);
                                         startActivity(i);
                                     }
                                 }

        );

        serm=(ImageView) findViewById(R.id.serm);
        serm.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         Intent i= new Intent(getApplicationContext(),search.class);
                                         startActivity(i);
                                     }
                                 }

        );


        sett=(TextView) findViewById(R.id.sett);
        sett.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i= new Intent(getApplicationContext(),setting.class);
                                        startActivity(i);
                                    }
                                }

        );

        setm=(ImageView) findViewById(R.id.setm);
        setm.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i= new Intent(getApplicationContext(),setting.class);
                                        startActivity(i);
                                    }
                                }

        );

    }





    }


