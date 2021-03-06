package loader;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Bean2.Shuma;
import Bean3.BBS;

/**
 * Created by Administrator on 16-9-5.
 */
public class HandlerJsonString31 {

    Handler handler;
    Gson gson=new Gson();
    List<BBS.ListBean> listBeen;
    BBS bbs;


    public HandlerJsonString31(Handler handler) {
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

                bbs=gson.fromJson(string, BBS.class);
                listBeen=bbs.getList();
                Log.d("ggl","========lisrBeen3======"+listBeen);
                Message message=Message.obtain();
                message.what=31;
                message.obj=listBeen;
                handler.sendMessage(message);//下载成功后发送消息



            }
        });
    }
}
