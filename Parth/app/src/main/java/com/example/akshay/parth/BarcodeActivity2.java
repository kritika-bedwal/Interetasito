package com.example.akshay.parth;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import static com.example.akshay.parth.ChatActivity.RC_PHOTO_PICKER;


public class BarcodeActivity2 extends AppCompatActivity {

    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode2);


        FloatingActionButton btn = (FloatingActionButton) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView myImageView = (ImageView) findViewById(R.id.imgview);
                Bitmap myBitmap = BitmapFactory.decodeResource(
                        getApplicationContext().getResources(),
                        R.drawable.attend);
                myImageView.setImageBitmap(myBitmap);


                BarcodeDetector detector =
                        new BarcodeDetector.Builder(getApplicationContext())
                                .setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.QR_CODE)
                                .build();
                if(!detector.isOperational()){
                    txtView.setText("Could not set up the detector!");
                    return;
                }


                Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
                SparseArray<Barcode> barcodes = detector.detect(frame);

                Barcode thisCode = barcodes.valueAt(0);
                txtView = (TextView) findViewById(R.id.txtContent);
                txtView.setText(thisCode.rawValue);
            }
        });
    }


    public void Click2(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 2500);

    }

    public void pick2(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/jpeg");
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), RC_PHOTO_PICKER);

    }
}
