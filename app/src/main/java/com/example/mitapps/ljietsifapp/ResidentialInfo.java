package com.example.mitapps.ljietsifapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ResidentialInfo extends AppCompatActivity {

    EditText studentcurrentaddressET,studentcurrentaddresspincodeET,studenthomehostelET,studenthostelfeesET,studentdistancefromljET;
    EditText studenttimetoreachljET;
    RadioGroup studentmodeoftransport;
    RadioButton studentmodeoftransportbtn;
    Button residential_next_btn, residential_prev_btn;

    private boolean errorFlag = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residential_info);

        studentcurrentaddressET=(EditText)findViewById(R.id.student_current_address_edit);
        studentcurrentaddresspincodeET=(EditText)findViewById(R.id.student_current_address_pin_edit);
        studenthomehostelET=(EditText)findViewById(R.id.student_home_hostel_edit);
        studenthostelfeesET=(EditText)findViewById(R.id.student_home_hostel_fees_per_month_edit);
        studentdistancefromljET=(EditText)findViewById(R.id.distance_from_lj_edit);
        studenttimetoreachljET=(EditText)findViewById(R.id.time_to_reach_edit);
        studentmodeoftransport=(RadioGroup)findViewById(R.id.mode_of_transportaion_radio_grp);
        studentmodeoftransportbtn=(RadioButton)findViewById(R.id.radio_public);

        residential_next_btn=(Button)findViewById(R.id.residential_next_btn);
        residential_prev_btn = (Button) findViewById(R.id.residential_prev_btn);

        residential_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNull(studentcurrentaddressET);
                checkNull(studentcurrentaddresspincodeET);
                checkNull(studenthomehostelET);
                checkNull(studenthostelfeesET);
                checkNull(studentdistancefromljET);
                checkNull(studenttimetoreachljET);

                if(studentmodeoftransport.getCheckedRadioButtonId()<=0){
                    studentmodeoftransportbtn.setError("This field must be filled!");
                }

                if (errorFlag) {
                    Intent i = new Intent(ResidentialInfo.this, ExtraInfo.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getBaseContext(), "Fill out every detail properly!!", Toast.LENGTH_LONG).show();
                    errorFlag = true;
                }
            }
        });

        residential_prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void checkNull(EditText et) {
        if (et.getText().toString().length() == 0) {
            et.setError("This field must be filled!!");
            errorFlag = false;
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        /*Log.i("MyMsg", "Residential onPause()");
        try {
            FileOutputStream fos = new FileOutputStream(MainFormActivity.residential_info_file);
            fos.write(getContext().getString(R.string.student_current_address_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.student_current_address_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_current_address_pin_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.student_current_address_pin_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_home_hostel_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.student_home_hostel_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_hostel_fees_per_month_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.student_home_hostel_fees_per_month_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.distance_from_lj_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.distance_from_lj_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.time_to_reach_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.time_to_reach_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.mode_of_transpotaion_txt).concat(": ").getBytes());
            radioButton = (RadioButton) getView().findViewById(R.id.radio_personal);
            if (radioButton.isChecked())
                fos.write("Personal\n\n".getBytes());
            else fos.write("Public\n\n".getBytes());

            fos.close();
            Log.i("MyMsg", "File Write Complete");
        } catch (FileNotFoundException e) {
            Log.i("MyMsg", "File not Found");
        } catch (IOException e) {
            Log.i("MyMsg", "IO");
        }*/
    }
}