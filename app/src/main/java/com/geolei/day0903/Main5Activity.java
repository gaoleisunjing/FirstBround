package com.geolei.day0903;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main5Activity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String name,password;
    Matcher matcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        initView();
    }

    private void initView() {
        editText1= (EditText) findViewById(R.id.fragment42EditText1Id);
        editText2= (EditText) findViewById(R.id.fragment42EditText2Id);
        button= (Button) findViewById(R.id.fragment42ButtonId);
        sharedPreferences=getSharedPreferences("gl",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        name=editText1.getText().toString();
        password=editText2.getText().toString();
        Pattern pattern=Pattern.compile("[1-9]\\d{4,13}");
         matcher=pattern.matcher(password);


    }

    public void onClick(View view){

        Log.d("gl","判断=============="+TextUtils.isEmpty(name));

       if(TextUtils.isEmpty(name)&&TextUtils.isEmpty(password)){
            Log.d("gl","========="+matcher.matches());
       //     if(matcher.matches()){
            Log.d("gl","=========gggggggggggggggggg");
                editor.putString("name",name);
                editor.putString("password",password);
                editor.commit();
                Main5Activity.this.finish();
    //        }
   // {
     //           Toast.makeText(getApplicationContext(),"不是有效的密码",Toast.LENGTH_LONG).show();

        //    }
        }else {
            Toast.makeText(getApplicationContext(),"别逗逼",Toast.LENGTH_LONG).show();

        }

    }

}
