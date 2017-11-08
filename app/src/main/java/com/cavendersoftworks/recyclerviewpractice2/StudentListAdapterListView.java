package com.cavendersoftworks.recyclerviewpractice2;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cavendersoftworks.recyclerviewpractice2.Model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentListAdapterListView extends ArrayAdapter<Student> {
    List<Student> mStudents;
    LayoutInflater mInflater;

    public StudentListAdapterListView(@NonNull Context context, @NonNull List<Student> objects) {
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

        TextView tvName = (TextView)convertView.findViewById(R.id.tv_NameDetail);
        TextView tvCompany = (TextView) convertView.findViewById(R.id.tv_CompanyDetail);
        ImageView profile = (ImageView)convertView.findViewById(R.id.imv_picture);

        Student student = mStudents.get(position);
        tvName.setText(student.getName());
        tvCompany.setText(student.getCompany());
        InputStream inputStream = null;

        try {
            String fileName = student.getImageName();
            inputStream = getContext().getAssets().open(fileName);
            Drawable d = Drawable.createFromStream(inputStream, null);
            profile.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//        QRCodeGenerator qr = new QRCodeGenerator(this.getContext(), imView);
//        qr.execute(studentName);

        return convertView;
    }


}
