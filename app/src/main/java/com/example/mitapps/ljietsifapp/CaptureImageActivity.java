package com.example.mitapps.ljietsifapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CaptureImageActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_IMAGE_CROP = 2;
    private ImageView studentPhoto, fatherPhoto, motherPhoto;
    private int buttonId;
    private Uri picUri;
    Button button_export;
    FileInputStream fis;
    FileOutputStream fos;
    BufferedReader br;
    BufferedWriter bw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_image);

        studentPhoto = (ImageView) findViewById(R.id.student_image);
        fatherPhoto = (ImageView) findViewById(R.id.father_image);
        motherPhoto = (ImageView) findViewById(R.id.mother_image);

        if (!hasCamera()) {
            Toast.makeText(this, "Oops! Your device doesn't have any camera", Toast.LENGTH_LONG).show();
        }
        button_export=(Button)findViewById(R.id.export_button);
        button_export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String string="";
                try {

                    fos = new FileOutputStream(MainFormActivity.sif_file);
                    bw = new BufferedWriter(new OutputStreamWriter(fos));

                    fis = new FileInputStream(MainFormActivity.personal_info_file);
                    br = new BufferedReader(new InputStreamReader(fis));

                    while ((string = br.readLine()) != null) {
                        bw.write(string);
                    }
                    Log.i("MyMsg", "File1 Complete");

                    fis = new FileInputStream(MainFormActivity.family_info_file);
                    br = new BufferedReader(new InputStreamReader(fis));
                    while ((string = br.readLine()) != null) {
                        bw.write(string);
                    }
                    Log.i("MyMsg", "File2 Complete");

                    fis = new FileInputStream(MainFormActivity.academic_info_file);
                    br = new BufferedReader(new InputStreamReader(fis));
                    while ((string = br.readLine()) != null) {
                        bw.write(string);
                    }
                    Log.i("MyMsg", "File3 Complete");

                    fis = new FileInputStream(MainFormActivity.residential_info_file);
                    br = new BufferedReader(new InputStreamReader(fis));
                    while ((string = br.readLine()) != null) {
                        bw.write(string);
                    }
                    Log.i("MyMsg", "File4 Complete");

                    fis = new FileInputStream(MainFormActivity.extra_info_file);
                    br = new BufferedReader(new InputStreamReader(fis));
                    while ((string = br.readLine()) != null) {
                        bw.write(string);
                    }
                    Log.i("MyMsg", "File5 Complete");

                    fis.close();
                    fos.close();

                    Log.i("MyMsg", "File Write is Complete");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Log.i("MyMsg", "File not found");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i("MyMsg", "IO");
                }*/

                Intent intent = new Intent(getApplicationContext(), SIFMainActivity.class);
                Log.i("MyMsg", "Activity Created");
                try {
                    startActivity(intent);
                    Log.i("MyMsg", "Activity Started");
                }catch (ActivityNotFoundException e){
                    Log.i("MyMsg", "Activity Not Found");
                }
            }
        });
    }

    public boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void captureImage (View view) {
        try{
            Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            switch (view.getId()) {
                case R.id.student_capture_button:
                    buttonId = R.id.student_capture_button;
                    break;
                case R.id.father_capture_button:
                    buttonId = R.id.father_capture_button;
                    break;
                case R.id.mother_capture_button:
                    buttonId = R.id.mother_capture_button;
                    break;
                default:
            }
            startActivityForResult(captureIntent, REQUEST_IMAGE_CAPTURE);
        }catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Oops! This device doesn't support image capture", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if(requestCode == REQUEST_IMAGE_CAPTURE) {
                picUri = data.getData();
                performCrop();
            }else  if (requestCode == REQUEST_IMAGE_CROP) {
                Bundle b = data.getExtras();
                Bitmap pic = b.getParcelable("data");
                switch (buttonId) {
                    case R.id.student_capture_button:
                        studentPhoto.setImageBitmap(pic);
                        break;
                    case R.id.father_capture_button:
                        fatherPhoto.setImageBitmap(pic);
                        break;
                    case R.id.mother_capture_button:
                        motherPhoto.setImageBitmap(pic);
                        break;
                    default:
                }
            }
        }
    }

    private void performCrop () {
        try {
            //call the standard crop action intent (the user device may not support it)
            Intent cropIntent = new Intent("com.android.camera.action.CROP");
            //indicate image type and Uri
            cropIntent.setDataAndType(picUri, "image/*");
            //set crop properties
            cropIntent.putExtra("crop", "true");
            //retrieve data on return
            cropIntent.putExtra("return-data", true);
            //start the activity - we handle returning in onActivityResult
            startActivityForResult(cropIntent, REQUEST_IMAGE_CROP);
        }catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Oops! This device doesn't support image crop", Toast.LENGTH_LONG).show();
        }
    }
}
