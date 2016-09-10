package fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.geolei.day0903.R;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import java.util.List;
import Bean.Instraction;
import adpter.MyFragment12BaseAdapter;
import loader.HandlerJsonString2;

/**
 * Created by Administrator on 16-9-7.
 */
public class MyFragment12 extends Fragment {

    String instraction_Path = "http://api.fengniao.com/app_ipad/news_list.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=296&page=";
    PullToRefreshGridView pullToRefreshGridView;
    GridView gridView;
    List<Instraction.ListBean> listBeen;
    private static int page = 1;
    MyFragment12BaseAdapter myFragment12BaseAdapter;


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 2) {
                listBeen = (List<Instraction.ListBean>) msg.obj;
                Log.d("ggl", "listBean==========" + listBeen);
                myFragment12BaseAdapter = new MyFragment12BaseAdapter(listBeen, getActivity());
                listBeen.addAll(listBeen);
                gridView.setAdapter(myFragment12BaseAdapter);
                myFragment12BaseAdapter.notifyDataSetChanged();

            }
        }
    };
    public MyFragment12 getFragment() {
        MyFragment12 myFragment12 = new MyFragment12();


        return myFragment12;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment12, container, false);

        pullToRefreshGridView = (PullToRefreshGridView) view.findViewById(R.id.pullToRefreshGridViewId);
        gridView = pullToRefreshGridView.getRefreshableView();


        if (page == 1) {
            HandlerJsonString2 jsonString2 = new HandlerJsonString2(handler);
            jsonString2.downLoadJsonString(instraction_Path + page);
        }

//        ++page;
//        HandlerJsonString2 jsonString2 = new HandlerJsonString2(handler);
//        jsonString2.downLoadJsonString(instraction_Path + page);
//        myFragment12BaseAdapter.notifyDataSetChanged();
//        pullToRefreshGridView.onRefreshComplete();



        ILoadingLayout loding=pullToRefreshGridView.getLoadingLayoutProxy(true,false);
        loding.setPullLabel("只有飞速的旋转才能止住泪水的掉落");
        loding.setRefreshingLabel("高磊君正在帮您加载...");
        loding.setReleaseLabel("刷新结束");

        ILoadingLayout loding1=pullToRefreshGridView.getLoadingLayoutProxy(false,true);
        loding1.setPullLabel("忘记你的模样");
        loding1.setRefreshingLabel("高磊君正在帮您加载...");
        loding1.setReleaseLabel("刷新结束");
        loding1.setLastUpdatedLabel("|_-0_0-_|");


        pullToRefreshGridView.setMode(PullToRefreshBase.Mode.BOTH);//一定要记得这个问题！
        pullToRefreshGridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                             if(page>1){
                                --page;
                                HandlerJsonString2 jsonString2 = new HandlerJsonString2(handler);
                                jsonString2.downLoadJsonString(instraction_Path + page);
                                myFragment12BaseAdapter.notifyDataSetChanged();
                                pullToRefreshGridView.onRefreshComplete();
                            }
                            }
                        });

                    }
                }).start();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                ++page;
                                HandlerJsonString2 jsonString2 = new HandlerJsonString2(handler);
                                jsonString2.downLoadJsonString(instraction_Path + page);
                                myFragment12BaseAdapter.notifyDataSetChanged();
                                pullToRefreshGridView.onRefreshComplete();
                            }
                        });

                    }
                }).start();
            }
        });


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
