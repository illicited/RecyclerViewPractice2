package com.cavendersoftworks.recyclerviewpractice2.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.cavendersoftworks.recyclerviewpractice2.Model.Student;
import com.cavendersoftworks.recyclerviewpractice2.QRCodeGenerator;
import com.cavendersoftworks.recyclerviewpractice2.R;
import com.cavendersoftworks.recyclerviewpractice2.StudentListAdapter;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Student student = getIntent().getExtras().getParcelable(StudentListAdapter.STUDENT_KEY);


        ImageView imView = (ImageView)findViewById(R.id.imv_barcode);
        TextView tvName = (TextView)findViewById(R.id.tv_NameDetail);
        TextView tvCompany = (TextView)findViewById(R.id.tv_CompanyDetail);
        TextView tvStatus = (TextView)findViewById(R.id.tv_StatusDetail);

        QRCodeGenerator qrcode = new QRCodeGenerator(this, imView);
        qrcode.execute(student.getItemId());
        tvName.setText(student.getName());
        tvCompany.setText(student.getCompany());
        tvStatus.setText(student.getStatus());

    }
}
