package com.example.wayupbeta;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wayupbeta.BoulderInfo;
import com.example.wayupbeta.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Button add_boulder, library;
    // creating a variable for our list view,
    // arraylist and firebase Firestore.
    ListView coursesLV;
    ArrayList<BoulderInfo> dataModalArrayList;

    FirebaseDatabase firebaseDatabase;

    // creating a variable for our
    // Database Reference for Firebase.
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // below line is use to initialize our variables
        coursesLV = findViewById(R.id.idLVCourses);
        dataModalArrayList = new ArrayList<>();

        // initializing our variable for firebase
        // firestore and getting its instance.
        // below line is used to get the instance
        // of our Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get
        // reference for our database.
        databaseReference = firebaseDatabase.getReference("Data");

        // here we are calling a method
        // to load data in our list view.
        loadDatainListview();
    /*
        add_boulder = findViewById(R.id.add_new);
        add_boulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddBoulder.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });
        library = findViewById(R.id.library);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, LVAdapter.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainActivity.this.startActivity(myIntent);
                //TODO implement library class with listview from Firebase
            }
        });
    */
    }

        private void loadDatainListview() {
            // below line is use to get data from Firebase
            // firestore using collection in android.
            databaseReference.child("Boulders").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            BoulderInfo boulder = dataSnapshot.getValue(BoulderInfo.class);

                            Toast.makeText(MainActivity.this, "Name: " + boulder.getBoulderName() + "\n" +
                                    "ImgUrl: " + boulder.getBoulderImageUrl(), Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            databaseReference.collection("Data").get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            // after getting the data we are calling on success method
                            // and inside this method we are checking if the received
                            // query snapshot is empty or not.
                            if (!queryDocumentSnapshots.isEmpty()) {
                                // if the snapshot is not empty we are hiding
                                // our progress bar and adding our data in a list.
                                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                                for (DocumentSnapshot d : list) {
                                    // after getting this list we are passing
                                    // that list to our object class.
                                    DataModal dataModal = d.toObject(DataModal.class);

                                    // after getting data from Firebase we are
                                    // storing that data in our array list
                                    dataModalArrayList.add(dataModal);
                                }
                                // after that we are passing our array list to our adapter class.
                                CoursesLVAdapter adapter = new CoursesLVAdapter(MainActivity.this, dataModalArrayList);

                                // after passing this array list to our adapter
                                // class we are setting our adapter to our list view.
                                coursesLV.setAdapter(adapter);
                            } else {
                                // if the snapshot is empty we are displaying a toast message.
                                Toast.makeText(MainActivity.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // we are displaying a toast message
                            // when we get any error from Firebase.
                            Toast.makeText(MainActivity.this, "Fail to load data..", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

}

