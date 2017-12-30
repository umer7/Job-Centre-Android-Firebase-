package com.example.umer.jobcentre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;



public class search extends AppCompatActivity  implements View.OnClickListener {

    public static  final String TAG="FIREBASE";

    public  RecyclerView recyclerListView;
    public  searchadp myAdapter;
    public EditText editbut;
    public Button buttonbut;
    // public  EditText editTextName;
    // public  EditText editTextCountry;
    //public  EditText editTextPhone;
    //public  EditText editTextEmail;
    Button buttonAdd;
    public  ProgressBar myProgressBar;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        editbut = (EditText) findViewById(R.id.editbut);
        buttonbut =(Button) findViewById(R.id.searchbut);
        buttonbut.setOnClickListener(this);

        databaseReference= FirebaseDatabase.getInstance().getReference();
        // creating layout
        creatingLayouts();
    }
    public void creatingLayouts(){
        myProgressBar=(ProgressBar) findViewById(R.id.loader);
        //  editTextName = (EditText) findViewById(R.id.nameEditText);
        //  editTextCountry=(EditText) findViewById(R.id.countryEditText);
        //  editTextPhone=(EditText) findViewById(R.id.weightEditText);
        //  editTextEmail = (EditText) findViewById(R.id.emailEditText);
        buttonAdd = (Button) findViewById(R.id.addButton);
        recyclerListView=(RecyclerView) findViewById(R.id.recylerview_list);
        recyclerListView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter= new searchadp(this);
        updateAdapter();
        recyclerListView.setAdapter(myAdapter);
    }

    //add new user to database


    // adding new user to end  the user using on firebase database


    //update adapter
    public void updateAdapter(){

        final List<User> listUsers= new ArrayList<>();

        String txt = editbut.getText().toString().trim();
        databaseReference.child("users").orderByChild("name").equalTo(txt).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                listUsers.add(dataSnapshot.getValue(User.class));
                displayUsers(listUsers);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Canceled",Toast.LENGTH_SHORT).show();
            }
        });


    }


    //display the user on Adapter
    public void displayUsers(List<User> ls){
        myProgressBar.setVisibility(View.GONE);
        recyclerListView.setVisibility(View.VISIBLE);
        // editTextName.setText(null);
        //  editTextCountry.setText(null);
        // editTextEmail.setText(null);
        myAdapter.setData(ls);
        myAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v== buttonbut)
        {
            updateAdapter();
        }
    }
}
