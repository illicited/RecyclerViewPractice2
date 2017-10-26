package com.cavendersoftworks.recyclerviewpractice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;


public class QRCodeGenerator extends AsyncTask<String, Void, Bitmap> {

    private Context context = null;

    public QRCodeGenerator(Context context) {
        this.context = context;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap bitmap = null;
        BitMatrix bitmatrix = null;
        int bitMatrixWidth;
        int bitMatrixHeight;
        int[] pixels;


        try {
            bitmatrix = new MultiFormatWriter().encode(strings[0], BarcodeFormat.DATA_MATRIX.QR_CODE, 500, 500, null);
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }

        bitMatrixWidth = bitmatrix.getWidth();
        bitMatrixHeight = bitmatrix.getHeight();

        pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for(int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for(int x = 0; x < bitMatrixWidth; x++) {
                pixels[offset + x] = bitmatrix.get(x, y) ?  context.getResources().getColor(R.color.QRCodeBlackColor) : context.getResources().getColor(R.color.QRCodeWhiteColor);

            }
        }

        bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);
        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);

        return bitmap;
    }
}
