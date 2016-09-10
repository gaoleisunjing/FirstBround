package loader;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Bean.Instraction;
import Bean.PhotoImage;

/**
 * Created by Administrator on 16-9-5.
 */
public class HandlerJsonString3 {

    Handler handler;
    Gson gson=new Gson();
    List<PhotoImage.ListBean> listBeen;
    PhotoImage photoImage;


    public HandlerJsonString3(Handler handler) {
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

                photoImage=gson.fromJson(string, PhotoImage.class);
                listBeen=photoImage.getList();
                Log.d("ggl","========lisrBeen3======"+listBeen);
                Message message=Message.obtain();
                message.what=3;
                message.obj=listBeen;
                handler.sendMessage(message);//下载成功后发送消息



            }
        });
    }
}
