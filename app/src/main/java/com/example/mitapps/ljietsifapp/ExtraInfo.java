package com.example.mitapps.ljietsifapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ExtraInfo extends AppCompatActivity {

    Button extra_next_btn, extra_prev_btn;
    EditText studentknowmanishsirET;
    RadioGroup studentknowmanishsir,studentpreferredcommunication;
    RadioButton studentknowmanishsirbtn,studentpreferredcommunicationbtn,studentknowmanishsiryesbtn;
    Spinner spinner;

    private boolean errorFlag = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_info);

        extra_next_btn = (Button) findViewById(R.id.extra_next_btn);
        extra_prev_btn = (Button) findViewById(R.id.extra_prev_btn);

        studentknowmanishsirET=(EditText)findViewById(R.id.know_manish_sir_peerzada_sir_edit);
        studentknowmanishsir=(RadioGroup)findViewById(R.id.know_manish_sir_peerzada_sir_radio_grp);
        studentknowmanishsirbtn=(RadioButton)findViewById(R.id.know_manish_sir_peerzada_sir_no_radio);
        studentknowmanishsiryesbtn=(RadioButton)findViewById(R.id.know_manish_sir_peerzada_sir_yes_radio);
        studentpreferredcommunication=(RadioGroup)findViewById(R.id.prefered_mode_of_comm_radio_grp);
        studentpreferredcommunicationbtn=(RadioButton)findViewById(R.id.radio_phone_call);

        extra_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(studentknowmanishsir.getCheckedRadioButtonId()<=0){
                    studentknowmanishsirbtn.setError("This field must be filled!");
                }
                if(studentknowmanishsiryesbtn.isChecked()){
                    checkNull(studentknowmanishsirET);
                }
                if(studentpreferredcommunication.getCheckedRadioButtonId()<=0){
                    studentpreferredcommunicationbtn.setError("This field must be filled!");
                }
                if (errorFlag) {
                    Intent i = new Intent(ExtraInfo.this, CaptureImageActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getBaseContext(), "Fill out every detail properly!!", Toast.LENGTH_LONG).show();
                    errorFlag = true;
                }
            }
        });

        extra_prev_btn.setOnClickListener(new View.OnClickListener() {
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
        /*Log.i("MyMsg", "Extras onPause()");
        try {
            FileOutputStream fos = new FileOutputStream(MainFormActivity.extra_info_file);
            System.out.println("File created");
            fos.write(getContext().getString(R.string.know_manish_sir_peerzada_sir_txt).concat(": ").getBytes());
            radioButton = (RadioButton) getView().findViewById(R.id.know_manish_sir_peerzada_sir_yes_radio);
            if (radioButton.isChecked())
                fos.write("Yes\n\n".getBytes());
            else fos.write("No\n\n".getBytes());

            fos.write("If knows Manish Sir/Peerzada Sir then how".concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.know_manish_sir_peerzada_sir_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.mention_family_member_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.mention_family_member_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.reason_for_opting_engineering_txt).concat(": ").getBytes());
            spinner = (Spinner) getView().findViewById(R.id.reason_for_opting_engineering_spinner);
            fos.write(spinner.getSelectedItem().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.reason_for_opting_lj_txt).concat(": ").getBytes());
            spinner = (Spinner) getView().findViewById(R.id.reason_for_opting_lj_spinner);
            fos.write(spinner.getSelectedItem().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.person_refered_lj_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.person_refered_lj_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.contact_of_referring_person_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.contact_of_referring_person_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.senior_name_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.senior_name_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.senior_enrollment_no_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.senior_enrollment_no_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.senior_mobile_no_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.senior_mobile_no_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.senior_present_sem_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.senior_present_sem_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.senior_branch_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.senior_branch_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.friend_name_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.friend_name_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.friend_enrollment_no_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.friend_enrollment_no_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.friend_mobile_no_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.friend_mobile_no_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.friend_branch_txt).concat(": ").getBytes());
            editText = (EditText) getView().findViewById(R.id.friend_branch_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.prefered_mode_of_comm_txt).concat(": ").getBytes());
            RadioButton rdbmale = (RadioButton) getView().findViewById(R.id.radio_whatsapp_msg);
            if (rdbmale.isChecked())
                fos.write("Whatsapp\n\n".getBytes());
            else fos.write("Phone\n\n".getBytes());

            fos.close();
            Log.i("MyMsg", "File Write Complete");
        } catch (FileNotFoundException e) {
            Log.i("MyMsg", "File not Found");
        } catch (IOException e) {
            Log.i("MyMsg", "IO");
        }*/
    }
}