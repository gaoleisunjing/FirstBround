package fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.geolei.day0903.R;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.List;

import Bean.Study;
import adpter.MyFragment14BaseAdapter;
import loader.HandlerJsonString4;

/**
 * Created by Administrator on 16-9-8.
 */
public class MyFragment14 extends Fragment {

    String Study_Path = "http://api.fengniao.com/app_ipad/news_list.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=190&page=";
    PullToRefreshGridView pullToRefreshGridView;
    GridView gridView;
    List<Study.ListBean> listBeen;
    private static int page = 1;
    MyFragment14BaseAdapter myFragment14BaseAdapter;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 4) {
                listBeen = (List<Study.ListBean>) msg.obj;
                myFragment14BaseAdapter = new MyFragment14BaseAdapter(listBeen, getActivity());
                listBeen.addAll(listBeen);
                gridView.setAdapter(myFragment14BaseAdapter);
                myFragment14BaseAdapter.notifyDataSetChanged();

            }

        }
    };


    public MyFragment14 getFragment() {
        MyFragment14 myFragment14 = new MyFragment14();


        return myFragment14;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment14, container, false);

        pullToRefreshGridView = (PullToRefreshGridView) view.findViewById(R.id.pullToRefreshGridView3Id);
        gridView = pullToRefreshGridView.getRefreshableView();

        if (page == 1) {
            HandlerJsonString4 jsonString2 = new HandlerJsonString4(handler);
            jsonString2.downLoadJsonString(Study_Path + page);
        }


        ILoadingLayout loding=pullToRefreshGridView.getLoadingLayoutProxy(true,false);
        loding.setPullLabel("只有飞速的旋转才能止住泪水的掉落");
        loding.setRefreshingLabel("高磊君正在帮您加载...");
        loding.setReleaseLabel("刷新结束");

        ILoadingLayout loding1=pullToRefreshGridView.getLoadingLayoutProxy(false,true);
        loding1.setPullLabel("忘记你的模样");
        loding1.setRefreshingLabel("高磊君正在帮您加载...");
        loding1.setReleaseLabel("刷新结束");
        loding1.setLastUpdatedLabel("|_-0_0-_|");



        pullToRefreshGridView.setMode(PullToRefreshBase.Mode.BOTH);
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
                                if (page > 1) {
                                    --page;
                                    HandlerJsonString4 jsonString2 = new HandlerJsonString4(handler);
                                    jsonString2.downLoadJsonString(Study_Path + page);
                                    myFragment14BaseAdapter.notifyDataSetChanged();
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
                                HandlerJsonString4 jsonString2 = new HandlerJsonString4(handler);
                                jsonString2.downLoadJsonString(Study_Path + page);
                                myFragment14BaseAdapter.notifyDataSetChanged();
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
