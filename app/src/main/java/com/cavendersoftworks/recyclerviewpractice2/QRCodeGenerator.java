package com.cavendersoftworks.recyclerviewpractice2;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.cavendersoftworks.recyclerviewpractice2.View.MainActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;


public class QRCodeGenerator extends AsyncTask<String, Void, Bitmap> {

    ProgressDialog dialog;

    private ImageView imv = null;
    private Context context = null;

    public QRCodeGenerator(Context context, ImageView imv) {
        this.context = context;
        this.imv = imv;
        dialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        this.dialog.setMessage("Loading..");
        this.dialog.show();
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

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imv.setImageBitmap(bitmap);
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
