package com.example.mitapps.ljietsifapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PersonalInfo extends AppCompatActivity {

    EditText studentfirstnameET,studentlastnameET,studentsurnameET,studentdobET,studentbranchET,studentmobnoET,studentresidentialnoET;
    EditText studentpermanentaddressET,studentpincodeET,studentreligionET,studentcasteET,studentbloodgroupET,studentemailidET;
    RadioGroup studentgenderRG;
    RadioButton studentgenderbtn;
    Button personal_next_btn;

    private boolean errorFlag = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        studentfirstnameET=(EditText)findViewById(R.id.student_first_name_edit);
        studentlastnameET=(EditText)findViewById(R.id.student_last_name_edit);
        studentsurnameET=(EditText)findViewById(R.id.student_surname_edit);
        studentgenderRG=(RadioGroup) findViewById(R.id.student_gender_radio_grp);
        studentgenderbtn=(RadioButton)findViewById(R.id.radio_female);
        studentdobET=(EditText)findViewById(R.id.student_dob_edit);
        studentbranchET=(EditText)findViewById(R.id.student_branch_edit);
        studentmobnoET=(EditText)findViewById(R.id.student_mobile_no_edit);
        studentresidentialnoET=(EditText)findViewById(R.id.student_residential_no_edit);
        studentpermanentaddressET=(EditText)findViewById(R.id.student_permanent_address_edit);
        studentpincodeET=(EditText)findViewById(R.id.student_permanent_address_pin_edit);
        studentreligionET=(EditText)findViewById(R.id.student_religion_edit);
        studentcasteET=(EditText)findViewById(R.id.student_caste_edit);
        studentbloodgroupET=(EditText)findViewById(R.id.student_blood_group_edit);
        studentemailidET=(EditText)findViewById(R.id.student_email_id_edit);

        personal_next_btn=(Button)findViewById(R.id.personal_next_btn);

        personal_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNull(studentfirstnameET);
                checkNull(studentlastnameET);
                checkNull(studentsurnameET);
                checkNull(studentemailidET);
                if (!Patterns.EMAIL_ADDRESS.matcher(studentemailidET.getText().toString()).matches()) {
                    studentemailidET.setError("Enter valid email address!!");
                    errorFlag = false;
                }

                if(studentgenderRG.getCheckedRadioButtonId()<=0){
                    studentgenderbtn.setError("This field must be filled!!");
                    errorFlag = false;
                }
                if(studentmobnoET.getText().toString().length()!=13){
                    studentmobnoET.setError("Invalid Mobile No!");
                    errorFlag = false;
                }
                if(studentresidentialnoET.getText().toString().length()!=11){
                    studentresidentialnoET.setError("Invalid Residential No!");
                    errorFlag = false;
                }
                checkNull(studentdobET);
                checkNull(studentbranchET);
                checkNull(studentpermanentaddressET);
                checkNull(studentpincodeET);
                checkLength(studentpincodeET, 6);
                checkNull(studentreligionET);
                checkNull(studentcasteET);
                checkNull(studentbloodgroupET);

                if (errorFlag) {
                    Intent i = new Intent(PersonalInfo.this, AcademicInfo.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getBaseContext(), "Fill out every detail properly!!", Toast.LENGTH_LONG).show();
                    errorFlag = true;
                }
            }
        });
    }

    private void checkNull(EditText et) {
        if (et.getText().toString().length() == 0) {
            et.setError("This field must be filled!!");
            errorFlag = false;
        }
    }

    private void checkLength(EditText et, int length) {
        if (et.getText().toString().length() != length) {
            et.setError("Enter valid input!!");
            errorFlag = false;
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        /*Log.i("MyMsg", "Pesonal onPause();");
        try{
            FileOutputStream fos=new FileOutputStream(MainFormActivity.personal_info_file);
            fos.write(getContext().getString(R.string.student_name_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_first_name_edit);
            fos.write(editText.getText().toString().concat(" ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_last_name_edit);
            fos.write(editText.getText().toString().concat(" ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_surname_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_gender_txt).concat(": ").getBytes());
            RadioButton rdbmale=(RadioButton)getView().findViewById(R.id.radio_male);
            if(rdbmale.isChecked())
            fos.write("Male\n\n".getBytes());
            else fos.write("Female\n\n".getBytes());

            fos.write(getContext().getString(R.string.student_dob_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_dob_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_branch_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_branch_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_email_id_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_email_id_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_mobile_no_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_mobile_no_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.residential_landline_no_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.residential_landline_no_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_permanent_address_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_permanent_address_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_permanent_address_pin_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_permanent_address_pin_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_religion_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_religion_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_caste_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_caste_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.reserve_category_txt).concat(": ").getBytes());
            spinner=(Spinner)getView().findViewById(R.id.reserve_category_spinner);
            fos.write(spinner.getSelectedItem().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.physically_handicapped_txt).concat(": ").getBytes());
            radioButton =(RadioButton)getView().findViewById(R.id.physically_handicapped_yes_radio);
            if(radioButton.isChecked())
            fos.write("Yes\n\n".getBytes());
            else fos.write("No\n\n".getBytes());

            fos.write(getContext().getString(R.string.economically_backward_txt).concat(": ").getBytes());
            radioButton =(RadioButton)getView().findViewById(R.id.economically_backward_yes_radio);
            if(radioButton.isChecked())
                fos.write("Yes\n\n".getBytes());
            else fos.write("No\n\n".getBytes());

            fos.write(getContext().getString(R.string.student_blood_group_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_blood_group_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_medical_history_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_medical_history_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_achievement_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_achievement_edit);
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