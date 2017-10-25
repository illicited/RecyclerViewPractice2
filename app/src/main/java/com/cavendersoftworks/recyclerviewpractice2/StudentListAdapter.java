package com.cavendersoftworks.recyclerviewpractice2;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cavendersoftworks.recyclerviewpractice2.Model.Student;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

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

    public Bitmap generateQR(String qrEncode) throws WriterException {
        Context context = this.getContext();

        Bitmap bitmap = null;
        BitMatrix bitmatrix = null;
        int bitMatrixWidth;
        int bitMatrixHeight;
        int[] pixels;


        try {
            bitmatrix = new MultiFormatWriter().encode(qrEncode, BarcodeFormat.DATA_MATRIX.QR_CODE, 150, 150, null);
        } catch (IllegalArgumentException e) {
            return null;
        }
        bitMatrixWidth = bitmatrix.getWidth();
        bitMatrixHeight = bitmatrix.getHeight();

        pixels = new int[bitMatrixHeight * bitMatrixWidth];

        for(int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for(int x = 0; x < bitMatrixWidth; x++) {
                pixels[offset + x] = bitmatrix.get(x, y) ?  context.getResources().getColor(R.color.QRCodeBlackColor) : context.getResources().getColor(R.color.QRCodeWhiteColor);

            }
        }

        bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);
        bitmap.setPixels(pixels, 0, 500, bitMatrixWidth, bitMatrixHeight, 150, 150);

        return bitmap;
    }
}
