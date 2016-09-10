package loader;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Bean.Title1;
import Bean2.Shuma;

/**
 * Created by Administrator on 16-9-5.
 */
public class Head1JsonString {

    Handler handler;
    Gson gson=new Gson();
    List<Title1> listBeen;
    Title1 title1;


    public Head1JsonString(Handler handler) {
        this.handler = handler;
    }

    public static ExecutorService executor= Executors.
            newFixedThreadPool(20);
    public void downLoadJsonString(final String url) {
        //线程池分配一个子线程
        executor.execute(new Runnable() {

            @Override
            public void run() {

                // TODO Auto-generated method stub
                String string=DownLoadUtils.getJsonString(url);
//                Type type=new TypeToken<List<Title1>>(){}.getType();
//                listBeen=gson.fromJson(string,type);

                title1=gson.fromJson(string, Title1.class);
                Log.d("wo","========TitleBeen1======"+title1);
                listBeen.add(title1);
                Message message=Message.obtain();
                message.what=110;
                message.obj=listBeen;
                Log.d("wo","============message"+listBeen);
                handler.sendMessage(message);//下载成功后发送消息



            }
        });
    }
}
