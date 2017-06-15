package com.example.mitapps.ljietsifapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SIFMainActivity extends AppCompatActivity{


    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifmain);

        button = (Button) findViewById(R.id.viewPDf);
        textView = (TextView) findViewById(R.id.textView2);

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri path = Uri.fromFile(MainFormActivity.sif_file);
                textView.setText(path.toString());
                Intent pdfOpenintent = new Intent(Intent.ACTION_VIEW);
                pdfOpenintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                pdfOpenintent.setDataAndType(path, "application/pdf");
                try {
                    startActivity(pdfOpenintent);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });*/
    }
}
