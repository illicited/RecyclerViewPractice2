package com.cavendersoftworks.recyclerviewpractice2.View;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cavendersoftworks.recyclerviewpractice2.Model.SampleData;
import com.cavendersoftworks.recyclerviewpractice2.Model.Student;
import com.cavendersoftworks.recyclerviewpractice2.QRCodeGenerator;
import com.cavendersoftworks.recyclerviewpractice2.R;
import com.cavendersoftworks.recyclerviewpractice2.StudentListAdapter;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String studentID = getIntent().getExtras().getString(StudentListAdapter.STUDENT_ID_KEY);
        Student student = SampleData.studentMap.get(studentID);


        ImageView imView = (ImageView)findViewById(R.id.imv_barcode);
        TextView tvName = (TextView)findViewById(R.id.tv_NameDetail);
        TextView tvCompany = (TextView)findViewById(R.id.tv_CompanyDetail);

        QRCodeGenerator qrcode = new QRCodeGenerator(this, imView);
        qrcode.execute(studentID);
        tvName.setText(student.getName());
        tvCompany.setText(student.getCompany());

    }
}
