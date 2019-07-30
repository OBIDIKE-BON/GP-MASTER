package com.izyapp.gpmaster.gp_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class GP_MASTER extends AppCompatActivity {

    DecimalFormat n = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp__master);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public synchronized void onResume() {
        super.onResume();
    }

    @Override
    public synchronized void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void onButtonClick(View v) {
        setGrades();

        double[] unit = new double[10];
        int totalLoad = 0;
        try {
            String[] load = {"", (((EditText) findViewById(R.id.load1)).getText().toString()), (((EditText) findViewById(R.id.load2)).getText().toString()),
                    (((EditText) findViewById(R.id.load3)).getText().toString()), (((EditText) findViewById(R.id.load4)).getText().toString()),
                    (((EditText) findViewById(R.id.load5)).getText().toString()), (((EditText) findViewById(R.id.load6)).getText().toString()),
                    (((EditText) findViewById(R.id.load7)).getText().toString()), (((EditText) findViewById(R.id.load8)).getText().toString()),
                    (((EditText) findViewById(R.id.load9)).getText().toString())};
           /* for(int i=1;i<=9;i++){
                unit[i] = computeUnit(((TextView)findViewById(R.id.grade+i)).getText().toString(), load[i]);
                if (load[i].trim().length()>0 ) {
                    try {
                        totalLoad += Integer.parseInt(load[i]);
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Wrong input!\n enter numbers only in your unit column" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }else{
                    totalLoad +=0;
                }
            }*/

            unit[1] = computeUnit(((TextView) findViewById(R.id.grade1)).getText().toString(), load[1]);
            unit[2] = computeUnit(((TextView) findViewById(R.id.grade2)).getText().toString(), load[2]);
            unit[3] = computeUnit(((TextView) findViewById(R.id.grade3)).getText().toString(), load[3]);
            unit[4] = computeUnit(((TextView) findViewById(R.id.grade4)).getText().toString(), load[4]);
            unit[5] = computeUnit(((TextView) findViewById(R.id.grade5)).getText().toString(), load[5]);
            unit[6] = computeUnit(((TextView) findViewById(R.id.grade6)).getText().toString(), load[6]);
            unit[7] = computeUnit(((TextView) findViewById(R.id.grade7)).getText().toString(), load[7]);
            unit[8] = computeUnit(((TextView) findViewById(R.id.grade8)).getText().toString(), load[8]);
            unit[9] = computeUnit(((TextView) findViewById(R.id.grade9)).getText().toString(), load[9]);

            for (int i = 1; i <= 9; i++) {
                if (load[i].trim().length() > 0) {
                    try {
                        totalLoad += Integer.parseInt(load[i]);
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Wrong input!\n enter numbers only in your unit column" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    totalLoad += 0;
                }
            }
            double totalUnit = unit[1] + unit[2] + unit[3] + unit[4] + unit[5] + unit[6] + unit[7] + unit[8] + unit[9];
            if (totalLoad == 0) {
                Toast.makeText(getApplicationContext(), "Please enter at least one score\nand its corresponding credit unit", Toast.LENGTH_LONG).show();
            } else {
                String gp = "GP:= " + n.format(totalUnit / totalLoad);
                ((TextView) findViewById(R.id.gp)).setText(gp);
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private String computeGrade(String scoreIn) {
        int score = 0;
        String grade = "";
        if (scoreIn.trim().length() > 0) {
            try {
                score = Integer.parseInt(scoreIn);
                if (score < 100) {
                    if (score >= 0) {
                        if (score >= 75) {
                            grade = "A";
                        } else if (score >= 70) {
                            grade = "AB";
                        } else if (score >= 65) {
                            grade = "B";
                        } else if (score >= 60) {
                            grade = "BC";
                        } else if (score >= 55) {
                            grade = "C";
                        } else if (score >= 50) {
                            grade = "CD";
                        } else if (score >= 45) {
                            grade = "D";
                        } else if (score >= 40) {
                            grade = "P";
                        } else if (score >= 30) {
                            grade = "F3";
                        } else if (score >= 20) {
                            grade = "F2";
                        } else if (score >= 10) {
                            grade = "F1";
                        } else {
                            grade = "F0";
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong input!\n enter numbers greater than or equal to zero ", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong input!\n enter numbers less than 100", Toast.LENGTH_LONG).show();
                }

            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Wrong input!\n enter numbers only in your score column", Toast.LENGTH_LONG).show();
            }
        } else {
            grade = "F0";
        }
        return grade;
    }

    private double computeUnit(String grade, String loadIn) {
        double unit = 0;
        int load = 0;
        if (loadIn.trim().length() > 0) {
            try {
                load = Integer.parseInt(loadIn);
                if ("A".equals(grade)) {
                    unit = (load * 4.0);
                } else if ("AB".equals(grade)) {
                    unit = (load * 3.50);
                } else if ("B".equals(grade)) {
                    unit = (load * 3.25);
                } else if ("BC".equals(grade)) {
                    unit = (load * 3.00);
                } else if ("C".equals(grade)) {
                    unit = (load * 2.75);
                } else if ("CD".equals(grade)) {
                    unit = (load * 2.50);
                } else if ("D".equals(grade)) {
                    unit = (load * 2.25);
                } else if ("P".equals(grade)) {
                    unit = (load * 2.00);
                } else if ("F3".equals(grade)) {
                    unit = (load * 1.50);
                } else if ("F2".equals(grade)) {
                    unit = (load * 1.00);
                } else if ("F1".equals(grade)) {
                    unit = (load * 0.50);
                } else if ("F0".equals(grade)) {
                    unit = (load * 0.00);
                }

            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Wrong input!\n enter numbers only in your score column", Toast.LENGTH_LONG).show();
            }
        } else {
            unit = (load * 0.00);
        }
        return unit;
    }

    private void setGrades() {
        String[] grades = {((EditText) findViewById(R.id.score1)).getText().toString(), ((EditText) findViewById(R.id.score2)).getText().toString()
                , ((EditText) findViewById(R.id.score3)).getText().toString(), ((EditText) findViewById(R.id.score4)).getText().toString()
                , ((EditText) findViewById(R.id.score5)).getText().toString(), ((EditText) findViewById(R.id.score6)).getText().toString()
                , ((EditText) findViewById(R.id.score7)).getText().toString(), ((EditText) findViewById(R.id.score8)).getText().toString()
                , ((EditText) findViewById(R.id.score9)).getText().toString()};
        try {
            ((TextView) findViewById(R.id.grade1)).setText(computeGrade(grades[0]));
            ((TextView) findViewById(R.id.grade2)).setText(computeGrade(grades[1]));
            ((TextView) findViewById(R.id.grade3)).setText(computeGrade(grades[2]));
            ((TextView) findViewById(R.id.grade4)).setText(computeGrade(grades[3]));
            ((TextView) findViewById(R.id.grade5)).setText(computeGrade(grades[4]));
            ((TextView) findViewById(R.id.grade6)).setText(computeGrade(grades[5]));
            ((TextView) findViewById(R.id.grade7)).setText(computeGrade(grades[6]));
            ((TextView) findViewById(R.id.grade8)).setText(computeGrade(grades[7]));
            ((TextView) findViewById(R.id.grade9)).setText(computeGrade(grades[8]));

        } catch (NumberFormatException ex) {
            Toast.makeText(getApplicationContext(), "Wrong inpute! characters,space(s)... are not allowed\n " +
                    "enter numbers only in the appropriate locations" + ex.getMessage(), Toast.LENGTH_LONG).show();
            //       + "\n click ok to continue", "error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent serverIntent = new Intent(GP_MASTER.this, helpActivity.class);
        // Launch the helpActivity to see help
        //   serverIntent = new Intent(this, helpActivity.class);
        startActivity(serverIntent);
        return true;
    }

}
