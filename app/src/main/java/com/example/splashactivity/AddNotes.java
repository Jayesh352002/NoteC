package com.example.splashactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AddNotes extends AppCompatActivity {
    Button btn_calc , btn_save ;
    EditText editText  ;
    LinearLayout l1 ;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        editText = findViewById(R.id.editText);
        Intent i = getIntent();
        String title = i.getStringExtra("data");
        editText.setText(title);
        //database = FirebaseDatabase.getInstance();
        //reference = database.getReference("AddNote");

    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);

        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.save_note) {

            String et = editText.getText().toString();

            if(et.equals(""))
            {
                Toast.makeText(this, "Empty Notes Cannot be Saved || Sorry !!!!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                //String key = et.substring(0,15);
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("AddNote");
                reference.child(et).setValue(et);
                Toast.makeText(this, "|| Done || ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Notes.class);
                //intent.putExtra("title",key);
                startActivity(intent);
                return true;
            }

        }

        else if(item.getItemId() == R.id.calc)
        {
            Intent i = new Intent(AddNotes.this , HomePage.class);
            startActivity(i);
        }

        return false;
    }
}