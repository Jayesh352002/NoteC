package com.example.splashactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.example.splashactivity.R.layout.activity_listview;
import static java.util.Arrays.*;

public class Notes extends AppCompatActivity {
    Button btn ;
    ListView listView ;
    ArrayList list = new ArrayList();
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        try{
            Intent i = getIntent();
            String title = i.getStringExtra("title");
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("AddNote");
            ref.addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot
                            int i = 0 ;
                            int n = (int) dataSnapshot.getChildrenCount();
                            for(DataSnapshot ds : dataSnapshot.getChildren())
                            {
                                String key = ds.getKey();
                                //array[i] = key ;
                                //i++;
                                list.add(key);
                                //Toast.makeText(Notes.this, "Key "+key, Toast.LENGTH_SHORT).show();

                            }
                            ArrayAdapter adapter = new ArrayAdapter<String>(Notes.this,
                                    activity_listview,list);
                            listView = findViewById(R.id.listView);
                            listView.setAdapter(adapter);
                            System.out.println(list);
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    for(int j = 0 ; j < n ; j++)
                                    {
                                        if(i==j)
                                        {
                                            Intent x = new Intent(Notes.this , AddNotes.class);
                                            x.putExtra("data" , String.valueOf(list.get(j)));
                                            startActivity(x);
                                        }
                                    }

                                }
                            });
                            //Toast.makeText(Notes.this, "Value : - "+dataSnapshot.getKey(), Toast.LENGTH_LONG).show();
                        }


                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            //handle databaseError
                        }
                    });

        }

        catch (NullPointerException e)
        {
            Toast.makeText(this, "Error is : "+e, Toast.LENGTH_SHORT).show();
        }
        btn = findViewById(R.id.add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Notes.this , AddNotes.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Notes.this , HomePage.class);
        startActivity(i);
    }
}