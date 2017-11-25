package com.cavendersoftworks.recyclerviewpractice2.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.cavendersoftworks.recyclerviewpractice2.Model.SampleData;
import com.cavendersoftworks.recyclerviewpractice2.Model.Student;
import com.cavendersoftworks.recyclerviewpractice2.R;
import com.cavendersoftworks.recyclerviewpractice2.StudentListAdapter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int SIGNIN_REQUEST = 1001;

    List<Student> studentList = SampleData.studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // studentName = (TextView)findViewById(R.id.tv_Name);
       // studentName.setText("");

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_1, studentNames
//        );

        StudentListAdapter adapter = new StudentListAdapter(studentList, this);
//        lv.setAdapter(arrayAdapter);
        RecyclerView rv =(RecyclerView) findViewById(R.id.rv_studentList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == SIGNIN_REQUEST) {
            String email = data.getStringExtra(LoginActivity.EMAIL_KEY);
            Toast.makeText(this, "You logged in as " + email, Toast.LENGTH_SHORT).show();

            SharedPreferences.Editor spEditor = getSharedPreferences("persistentData", MODE_PRIVATE).edit();
            spEditor.putString(LoginActivity.EMAIL_KEY, email);
            spEditor.apply();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.signin_action :
                Intent intent = new Intent(this, LoginActivity.class);
                startActivityForResult(intent, SIGNIN_REQUEST);
                return true;
            case R.id.settings_action :
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
