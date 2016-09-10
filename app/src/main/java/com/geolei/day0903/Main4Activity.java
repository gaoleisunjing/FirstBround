package com.geolei.day0903;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {


    EditText editText1,editText2;
    Button button1,button2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String name,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main4);

        initView();
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    private void initView() {
        editText1= (EditText) findViewById(R.id.fragment4EditText1Id);
        editText2= (EditText) findViewById(R.id.fragment4EditText2Id);
        button1= (Button) findViewById(R.id.fragment4Button1Id);
        button2= (Button) findViewById(R.id.fragment4Button2Id);

        sharedPreferences=this.getSharedPreferences("gl",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        name=editText1.getText().toString();
        password=editText2.getText().toString();
    }

    @Override
    public void onClick(View view) {

       switch(view.getId()){

           case R.id.fragment4Button1Id:
               Intent intent=new Intent(this,Main5Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               this.startActivity(intent);



               break;

           case R.id.fragment4Button2Id:
            if(TextUtils.isEmpty(name)&&TextUtils.isEmpty(password)){
                //name!=null&&password!=null  自己想的 还没有试试
                if(name.equals(sharedPreferences.getString("name",name))&&password.equals(sharedPreferences.getString("password",password))){
                    Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_LONG).show();
                    Main4Activity.this.finish();//结束
                }


            }else {
                Toast.makeText(getApplicationContext(),"用户名或密码不能为空或非法的用户名",Toast.LENGTH_LONG).show();

            }



               break;
       }








    }
}
