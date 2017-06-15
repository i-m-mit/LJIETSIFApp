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

public class FamilyInfo extends AppCompatActivity {

    EditText studentfathernameET,studentfathereduET,studentfatheroccupationET,studentfatheremailIDET,studentfathermobnoET;
    EditText studentmothernameET,studentmothereduET,studentmotheroccupationET,studentmothermobnoET,studentparentwhatsappnoET,studentguardianwhatsappnoET;
    EditText studentsibling1ageET,studentsibling1nameET,studentsibling1eduET,studentsibling1contactET;
    EditText studentsibling2ageET,studentsibling2nameET,studentsibling2eduET,studentsibling2contactET;
    RadioGroup studentattendanceresult;
    RadioButton studentattendanceresultbtn;
    Button family_next_btn, family_prev_btn;

    private boolean errorFlag = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_info);

        studentfathernameET=(EditText)findViewById(R.id.father_name_edit);
        studentfathereduET=(EditText)findViewById(R.id.father_edu_edit);
        studentfatheroccupationET=(EditText)findViewById(R.id.father_occupation_edit);
        studentfatheremailIDET=(EditText)findViewById(R.id.father_email_id_edit);
        studentfathermobnoET=(EditText)findViewById(R.id.father_mobile_no_edit);
        studentmothernameET=(EditText)findViewById(R.id.mother_name_edit);
        studentmothereduET=(EditText)findViewById(R.id.mother_edu_edit);
        studentmotheroccupationET=(EditText)findViewById(R.id.mother_occupation_edit);
        studentmothermobnoET=(EditText)findViewById(R.id.mother_mobile_no_edit);
        studentparentwhatsappnoET=(EditText)findViewById(R.id.parents_whatsapp_no_edit);
        studentguardianwhatsappnoET=(EditText)findViewById(R.id.guardian_whatsapp_no_edit);

        studentattendanceresult=(RadioGroup)findViewById(R.id.want_attandence_radio_grp);
        studentattendanceresultbtn=(RadioButton)findViewById(R.id.want_attandence_no_radio);

        family_next_btn = (Button)findViewById(R.id.family_next_btn);
        family_prev_btn = (Button)findViewById(R.id.family_prev_btn);


        family_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(studentattendanceresult.getCheckedRadioButtonId()<=0){
                    studentattendanceresultbtn.setError("This field must be filled!");
                }
                checkNull(studentfathernameET);
                checkNull(studentfathereduET);
                checkNull(studentfathermobnoET);
                checkNull(studentfatheroccupationET);
                checkNull(studentfatheremailIDET);
                checkNull(studentmothereduET);
                checkNull(studentmothermobnoET);
                checkNull(studentmothernameET);
                checkNull(studentmotheroccupationET);
                checkNull(studentparentwhatsappnoET);
                checkNull(studentguardianwhatsappnoET);

                if (errorFlag) {
                    Intent i = new Intent(FamilyInfo.this, ResidentialInfo.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getBaseContext(), "Fill out every detail properly!!", Toast.LENGTH_LONG).show();
                    errorFlag = true;
                }
            }
        });

        family_prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void checkNull(EditText et) {
        if (et.getText().toString().length() == 0) {
            et.setError("This field must be filled!!");
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        /*Log.i("MyMsg", "Family onPause();");
        try{
            FileOutputStream fos=new FileOutputStream(MainFormActivity.family_info_file);
            fos.write(getContext().getString(R.string.father_name_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.father_name_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.father_edu_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.father_edu_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.father_occupation_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.father_occupation_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.father_email_id_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.father_email_id_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.father_mobile_no_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.father_mobile_no_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.mother_name_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.mother_name_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.mother_edu_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.mother_edu_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.mother_occupation_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.mother_occupation_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.mother_mobile_no_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.mother_mobile_no_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.want_attendance_txt).concat(": ").getBytes());
            radioButton =(RadioButton)getView().findViewById(R.id.want_attandence_yes_radio);
            if(radioButton.isChecked())
                fos.write("Yes\n\n".getBytes());
            else fos.write("No\n\n".getBytes());

            fos.write(getContext().getString(R.string.parent_whatapp_no_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.parents_whatsapp_no_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.guardian_whatsapp_no_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.guardian_whatsapp_no_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.bro_sis_name_one_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.bro_sis_name_one_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.bro_sis_age_one_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.bro_sis_age_one_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.bro_sis_edu_one_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.bro_sis_edu_one_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.bro_sis_contact_no_one_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.bro_sis_contact_no_one_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.bro_sis_name_two_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.bro_sis_name_two_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.bro_sis_age_two_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.bro_sis_age_two_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.bro_sis_edu_two_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.bro_sis_edu_two_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.bro_sis_contact_no_two_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.bro_sis_contact_no_two_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.close();
            Log.i("MyMsg", "File Write Complete");
        } catch (FileNotFoundException e) {
            Log.i("MyMsg", "File not Found");
        } catch (IOException e) {
            Log.i("MyMsg", "IO");
        }*/
    }
}