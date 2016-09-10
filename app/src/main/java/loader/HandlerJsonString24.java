package loader;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Bean2.Environment;
import Bean2.Shuma;

/**
 * Created by Administrator on 16-9-5.
 */
public class HandlerJsonString24 {

    Handler handler;
    Gson gson=new Gson();
    List<Shuma.ListBean> listBeen;
    Shuma shuma;


    public HandlerJsonString24(Handler handler) {
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
               // Type type=new TypeToken<List<Instraction.ListBean>>(){}.getType();

                shuma=gson.fromJson(string, Shuma.class);
                listBeen=shuma.getList();
                Log.d("ggl","========lisrBeen3======"+listBeen);
                Message message=Message.obtain();
                message.what=24;
                message.obj=listBeen;
                handler.sendMessage(message);//下载成功后发送消息



            }
        });
    }
}
