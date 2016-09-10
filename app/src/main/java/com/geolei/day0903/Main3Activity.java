package com.geolei.day0903;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.List;

import Bean3.BBS;
import adpter.MyFragment31BaseAdapter;
import loader.HandlerJsonString31;

public class Main3Activity extends AppCompatActivity {

    String BBS_Path="http://api.fengniao.com/app_ipad/bbs_all_hot.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&page=1";
    ListView listView;
    List<BBS.ListBean> listBean;
    MyFragment31BaseAdapter adapter;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==31){
            listBean= (List<BBS.ListBean>) msg.obj;
          adapter=new MyFragment31BaseAdapter(listBean,getApplicationContext());
           listView.setAdapter(adapter);

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去除title
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);//去除状态栏
        setContentView(R.layout.activity_main3);

        initView();
        initData();

    }

    private void initData() {
        HandlerJsonString31 jsonString=new HandlerJsonString31(handler);
        jsonString.downLoadJsonString(BBS_Path);

    }

    private void initView() {
        listView= (ListView) findViewById(R.id.main3ListViewId);
    }


}
