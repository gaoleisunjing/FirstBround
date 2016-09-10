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

import Bean2.Shuma;
import adpter.MyFragment24BaseAdapter;
import loader.HandlerJsonString24;

/**
 * Created by Administrator on 16-9-8.
 */
public class MyFragment24 extends Fragment {

    String Shuma_Path = "http://api.fengniao.com//app_ipad/pic_bbs_list_v2.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&fid=24&page=";
    PullToRefreshGridView pullToRefreshGridView;
    GridView gridView;
    List<Shuma.ListBean> listBeen;
    private static int page = 1;
    MyFragment24BaseAdapter myFragment24BaseAdapter;


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 24) {
                listBeen = (List<Shuma.ListBean>) msg.obj;
                myFragment24BaseAdapter = new MyFragment24BaseAdapter(listBeen, getActivity());
                listBeen.addAll(listBeen);
                gridView.setAdapter(myFragment24BaseAdapter);
                myFragment24BaseAdapter.notifyDataSetChanged();
            }
        }
    };


    public MyFragment24 getFragment() {
        MyFragment24 myFragment24 = new MyFragment24();

        return myFragment24;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment24, container, false);
        pullToRefreshGridView = (PullToRefreshGridView) view.findViewById(R.id.pullToRefreshGridView24Id);
        gridView = pullToRefreshGridView.getRefreshableView();

        if (page == 1) {
            HandlerJsonString24 jsonString2 = new HandlerJsonString24(handler);
            jsonString2.downLoadJsonString(Shuma_Path + page);
        }


        ILoadingLayout loding = pullToRefreshGridView.getLoadingLayoutProxy(true, false);
        loding.setPullLabel("只有飞速的旋转才能止住泪水的掉落");
        loding.setRefreshingLabel("高磊君正在帮您加载...");
        loding.setReleaseLabel("刷新结束");

        ILoadingLayout loding1 = pullToRefreshGridView.getLoadingLayoutProxy(false, true);
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
                                    HandlerJsonString24 jsonString2 = new HandlerJsonString24(handler);
                                    jsonString2.downLoadJsonString(Shuma_Path + page);
                                    myFragment24BaseAdapter.notifyDataSetChanged();
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
                                HandlerJsonString24 jsonString2 = new HandlerJsonString24(handler);
                                jsonString2.downLoadJsonString(Shuma_Path + page);
                                myFragment24BaseAdapter.notifyDataSetChanged();
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
