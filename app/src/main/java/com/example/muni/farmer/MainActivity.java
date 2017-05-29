package com.example.muni.farmer;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.text1;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private RadioButton radioSexButton;
    private RadioGroup radioSexGroup;
    Button button,dilagbutton,button1;
    Dialog dialog;
    EditText aadhar, code, name, mcow,mbuffalo,dcow,dbuffalo,total;
    TextView text1,text2,text3,text4,text5,text6,text7,text8,text9;
    String faadhar, fcode, fname, fmcow,fmbuffalo,fdcow,fdbuffalo,ftotal,dodla;
    int cow=0,buff=0,dryc=0,dryb=0,totalani=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioSexGroup=(RadioGroup)findViewById(R.id.radioGroup);

        aadhar = (EditText) findViewById(R.id.aadhar1);
        code = (EditText) findViewById(R.id.code1);
        name = (EditText) findViewById(R.id.name1);
        mcow = (EditText) findViewById(R.id.cows1);
        mbuffalo = (EditText) findViewById(R.id.buffalos1);
        dcow = (EditText) findViewById(R.id.drycow1);
        dbuffalo = (EditText) findViewById(R.id.drybuf1);
        total = (EditText) findViewById(R.id.total1);
        button =(Button) findViewById(R.id.button);
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdata();
                cow=Integer.valueOf(fmcow);
                buff=Integer.valueOf(fmbuffalo);
                dryc=Integer.valueOf(fdcow);
                dryb=Integer.valueOf(fdbuffalo);
                totalani=cow+buff+dryb+dryc;
                ftotal=String.valueOf(totalani);
                total.setText(ftotal);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdata();

                    if (faadhar.equals("") || fmcow.equals("") || fmbuffalo.equals("") || fdcow.equals("") || fdbuffalo.equals("") || dodla.equals("")) {
                        Toast.makeText(MainActivity.this, "Please enter the mandatory fields", Toast.LENGTH_SHORT).show();
                    return;
                    }
                        dilag();
                }
        });

    }
    public void  getdata(){
        faadhar = aadhar.getText().toString();
        fcode = code.getText().toString();
        fname = name.getText().toString();
        fmcow = mcow.getText().toString();
        fmbuffalo = mbuffalo.getText().toString();
        fdcow = dcow.getText().toString();
        ftotal=String.valueOf(totalani);
        fdbuffalo = dbuffalo.getText().toString();
        int selectedId = radioSexGroup.getCheckedRadioButtonId();
        radioSexButton = (RadioButton) findViewById(selectedId);
        if (radioSexButton != null) {
            dodla = radioSexButton.getText().toString();
        }
    }
    public void dilag(){
        getdata();
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dilag);
        dialog.setTitle("Details");
        text1 = (TextView) dialog.findViewById(R.id.aadh1);
        text1.setText(faadhar);
        text2 = (TextView) dialog.findViewById(R.id.co1);
        text2.setText(fcode);
        text3 = (TextView) dialog.findViewById(R.id.na1);
        text3.setText(fname);
        text4 = (TextView) dialog.findViewById(R.id.dc1);
        text4.setText(fmcow);
        text5 = (TextView) dialog.findViewById(R.id.db1);
        text5.setText(fmbuffalo);
        text6 = (TextView) dialog.findViewById(R.id.mc1);
        text6.setText(fdcow);
        text7 = (TextView) dialog.findViewById(R.id.mb1);
        text7.setText(fdbuffalo);
        text8 = (TextView) dialog.findViewById(R.id.to1);
        text8.setText(ftotal);
        text9 = (TextView) dialog.findViewById(R.id.do1);
        text9.setText(dodla);
        dialog.show();
        dilagbutton=(Button) dialog.findViewById(R.id.button2);
        button1=(Button) dialog.findViewById(R.id.button1);
        dilagbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"You clicked Save button",Toast.LENGTH_LONG).show();
            }
        });
    }

}
