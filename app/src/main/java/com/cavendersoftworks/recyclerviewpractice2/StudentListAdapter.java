package com.cavendersoftworks.recyclerviewpractice2;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cavendersoftworks.recyclerviewpractice2.Model.Student;
import java.util.List;

public class StudentListAdapter extends ArrayAdapter<Student> {
    List<Student> mStudents;
    LayoutInflater mInflater;

    public StudentListAdapter(@NonNull Context context, @NonNull List<Student> objects) {
        super(context, R.layout.list_student, objects);

        mStudents = objects;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_student, parent, false);
        }

        TextView tvName = (TextView)convertView.findViewById(R.id.tv_Name);
        ImageView imView = (ImageView)convertView.findViewById(R.id.iv_barcode);

        Student student = mStudents.get(position);
        tvName.setText(student.getName());
        imView.setImageResource(R.drawable.barcode);

        return convertView;
    }
}
