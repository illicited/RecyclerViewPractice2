package com.cavendersoftworks.recyclerviewpractice2.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import com.cavendersoftworks.recyclerviewpractice2.Model.SampleData;
import com.cavendersoftworks.recyclerviewpractice2.Model.Student;
import com.cavendersoftworks.recyclerviewpractice2.R;
import com.cavendersoftworks.recyclerviewpractice2.StudentListAdapter;
import com.cavendersoftworks.recyclerviewpractice2.StudentListAdapterListView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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


}
