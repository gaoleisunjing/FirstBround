package loader;

import android.os.Handler;
import android.os.Message;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import Bean.ToBean;

/**
 * Created by Administrator on 16-9-5.
 */
public class HandlerJsonString {
    List<ToBean.SecondBean> secondBeen;
    List<ToBean.ThirdBean> thirdBeen;
    Handler handler;
    Map<String ,Object>map=new HashMap<>();
    Gson gson=new Gson();

    public HandlerJsonString(Handler handler) {
        this.handler = handler;
    }

    public static ExecutorService executor= Executors.
            newFixedThreadPool(10);
    public void downLoadJsonString(final String url) {
        //线程池分配一个子线程
        executor.execute(new Runnable() {

            @Override
            public void run() {

                // TODO Auto-generated method stub
                String string=DownLoadUtils.getJsonString(url);
                String strings=string.replace("280280","Second");
                String str=strings.replace("160120","Third");


                ToBean toBean = gson.fromJson(str,ToBean.class);
//                secondBeen = toBean1.getSecond();
//                Log.d("gl","---解析second_Been---"+secondBeen);
//                Type type=new TypeToken<List<ToBean>>(){}.getType();
////                secondBeen  = new Gson(strings,new TypeToken<List<ToBean.SecondBean>>().getType());
//                ToBean toBean=gson.fromJson(string,ToBean.class);

//                Type type=new TypeToken<List<ToBean>>(){}.getType();
//                List<ToBean> list=gson.fromJson(str,type);
//                secondBeen=list;

//                Log.d("gl","gson===================="+toBean.getSecond().get(1).getTitle().toString());
                secondBeen=toBean.getSecond();
                thirdBeen=toBean.getThird();

                map.put("gl2",secondBeen);
//                Log.d("gl", "secondList=========tag"+tag);

//                ++page;
//                Log.d("gl","second"+secondBeen);
                map.put("gl3",thirdBeen);
//                Log.d("gl", "secondList=========tag"+tag);
//
//                Log.d("gl","third"+thirdBeen);

                Message message=Message.obtain();
                message.what=1;
                message.obj=map;
                handler.sendMessage(message);//下载成功后发送消息

            }
        });
    }
}
