package com.example.mitapps.ljietsifapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AcademicInfo extends AppCompatActivity {

    EditText studentNameEt, sscResultEt, hscMathsResultEt, hscPhysResultEt, hscChemResultEt;
    EditText jeeMarsksEt, meritMarksEt, meritNoEt, schoolNameEt;
    Spinner mediumOfStudySp, boardOfStudySp;
    Button academic_next_btn, academic_prev_btn;

    private boolean errorFlag = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_info);

        studentNameEt = (EditText) findViewById(R.id.student_name_as_per_ssc_edit);
        sscResultEt = (EditText) findViewById(R.id.student_ssc_result_edit);
        hscMathsResultEt = (EditText) findViewById(R.id.student_hsc_result_maths_edit);
        hscPhysResultEt = (EditText) findViewById(R.id.student_hsc_result_physics_edit);
        hscChemResultEt = (EditText) findViewById(R.id.student_hsc_result_chem_edit);
        jeeMarsksEt = (EditText) findViewById(R.id.student_jee_marks_edit);
        meritMarksEt = (EditText) findViewById(R.id.student_merit_marks_edit);
        meritNoEt = (EditText) findViewById(R.id.student_merit_no_edit);
        schoolNameEt = (EditText) findViewById(R.id.student_school_name_city_edit);
        mediumOfStudySp = (Spinner) findViewById(R.id.medium_of_study_spinner);
        boardOfStudySp = (Spinner) findViewById(R.id.student_board_in_school_spinner);

        academic_next_btn = (Button)findViewById(R.id.academic_next_btn);
        academic_prev_btn = (Button) findViewById(R.id.academic_prev_btn);

        academic_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNull(studentNameEt);
                checkNull(sscResultEt);
                checkNull(hscPhysResultEt);
                checkNull(hscChemResultEt);
                checkNull(hscMathsResultEt);
                checkNull(jeeMarsksEt);
                checkNull(meritMarksEt);
                checkNull(meritNoEt);
                checkNull(schoolNameEt);

                checkRange(sscResultEt,500);
                checkRange(hscPhysResultEt,100);
                checkRange(hscChemResultEt,100);
                checkRange(hscMathsResultEt,100);
                checkRange(jeeMarsksEt,360);
                checkRange(meritMarksEt,100);

                if (errorFlag) {
                    Intent i = new Intent(AcademicInfo.this, FamilyInfo.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getBaseContext(), "Fill out every detail properly!!", Toast.LENGTH_LONG).show();
                    errorFlag = true;
                }
            }
        });

        academic_prev_btn.setOnClickListener(new View.OnClickListener() {
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

    private void checkRange(EditText et, int range) {
        try {
            int marks = Integer.parseInt(et.getText().toString());
            if (marks > range) {
                et.setError("Out of range(0-" + range + ")!!");
                errorFlag = false;
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void onPause() {
        super.onPause();
       /* Log.i("MyMsg", "Academic onPause();");
        try {
            FileOutputStream fos = new FileOutputStream(MainFormActivity.academic_info_file);
            fos.write(getContext().getString(R.string.student_name_as_per_ssc_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_name_as_per_ssc_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_ssc_result_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_ssc_result_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_name_as_per_ssc_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_name_as_per_ssc_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_hsc_result_maths_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_hsc_result_maths_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_hsc_result_chem_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_hsc_result_chem_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_hsc_result_physics_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_hsc_result_physics_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_jee_marks_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_jee_marks_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_merit_marks_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_merit_marks_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_merit_no_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_merit_no_edit);
            fos.write(editText.getText().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_medium_of_study_txt).concat(": ").getBytes());
            spinner =(Spinner)getView().findViewById(R.id.medium_of_study_spinner);
            fos.write(spinner.getSelectedItem().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_board_in_school_txt).concat(": ").getBytes());
            spinner=(Spinner)getView().findViewById(R.id.student_board_in_school_spinner);
            fos.write(spinner.getSelectedItem().toString().concat("\n\n").getBytes());

            fos.write(getContext().getString(R.string.student_school_name_city_txt).concat(": ").getBytes());
            editText =(EditText)getView().findViewById(R.id.student_school_name_city_edit);
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