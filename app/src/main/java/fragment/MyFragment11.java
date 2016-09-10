package fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.geolei.day0903.MyWebActivity;
import com.geolei.day0903.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Bean.ToBean;
import Pageradapter.MyHandViewPagerAdapter;
import adpter.MyFragment11BaseAdapter;
import loader.DownLoadUtils;
import loader.HandlerJsonString;

/**
 * Created by Administrator on 16-9-3.
 */
public class MyFragment11 extends Fragment {


    PullToRefreshListView pullToRefreshListView;
    List<ToBean.SecondBean> secondBeanList;
    List<ToBean.ThirdBean> thirdBeenlist;
    Map<String, List> datalist;
    MyFragment11BaseAdapter myFragment11BaseAdapter;

    private static int page=1;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                datalist = (Map<String, List>) msg.obj;

                Log.d("gl","datalist==============="+datalist.size());
                secondBeanList = (List<ToBean.SecondBean>) datalist.get("gl2");

                thirdBeenlist= (List<ToBean.ThirdBean>) datalist.get("gl3");
   myFragment11BaseAdapter = new MyFragment11BaseAdapter(secondBeanList, thirdBeenlist, getActivity());
                pullToRefreshListView.setAdapter(myFragment11BaseAdapter);

            }
        }
    };


    LinearLayout linearLayout;//头部试图的父类
    ViewPager viewPager;//放头文件的viewPager
    List<Fragment> handfragment;
    MyHandViewPagerAdapter handViewPagerAdapter;
    MyFragment11head1 myFragment11head1;
    MyFragment11head12 myFragment11head2;
    MyFragment11head13 myFragment11head3;


    String res_path = "http://api.fengniao.com/app_ipad/news_jingxuan.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&page=";


    String url;//点击事件

    public MyFragment11 getFragment() {
        MyFragment11 myFragment11 = new MyFragment11();


        return myFragment11;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_fragment11, null);
        Log.d("gl", "开始");

        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pullToRefreshListViewId);
        // adapter = new ArrayAdapter<String>(getContext(), R.layout.item_fragment11adapter, datas);


        Log.d("gl", "结束");


//        ImageView imageView = new ImageView(getContext());
//        imageView.setImageResource(R.mipmap.ic_launcher);
//        pullToRefreshListView.getRefreshableView().addHeaderView(imageView);


        handfragment = new ArrayList<>();
        handfragment.add(new MyFragment11head1());
        handfragment.add(new MyFragment11head12());
        handfragment.add(new MyFragment11head13());

        //头部试图
        viewPager = (ViewPager) LayoutInflater.from(getActivity()).inflate(R.layout.item_fragment11headview, null);
        Log.d("gl", "1");
        DisplayMetrics displayMetrics = new DisplayMetrics();//获取屏幕像素信息
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        handViewPagerAdapter = new MyHandViewPagerAdapter(getChildFragmentManager(), handfragment);
        handViewPagerAdapter.notifyDataSetChanged();
        viewPager.setAdapter(handViewPagerAdapter);
        viewPager.setCurrentItem(1);
        LinearLayout layout = new LinearLayout(getActivity());
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels / 6;
        viewPager.setLayoutParams(new ViewGroup.LayoutParams(width, height));
        layout.addView(viewPager);
        Log.d("gl", "6" + viewPager);
        pullToRefreshListView.getRefreshableView().addHeaderView(layout);
        Log.d("gl", "7");


       if(page==1){ String url_path=res_path+page;
        HandlerJsonString handlerJsonString = new HandlerJsonString(handler);
        handlerJsonString.downLoadJsonString(url_path);
       }

        ILoadingLayout loding=pullToRefreshListView.getLoadingLayoutProxy(true,false);
        loding.setPullLabel("只有飞速的旋转才能止住泪水的掉落");
        loding.setRefreshingLabel("高磊君正在帮您加载...");
        loding.setReleaseLabel("刷新结束");

        ILoadingLayout loding1=pullToRefreshListView.getLoadingLayoutProxy(false,true);
        loding1.setPullLabel("忘记你的模样");
        loding1.setRefreshingLabel("高磊君正在帮您加载...");
        loding1.setReleaseLabel("刷新结束");
        loding1.setLastUpdatedLabel("|_-0_0-_|");

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //pullToRefreshListView.requestDisallowInterceptTouchEvent(true);//拦截
            }

            @Override
            public void onPageSelected(int position) {

               // pullToRefreshListView.requestDisallowInterceptTouchEvent(false);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(3000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                viewPager.setCurrentItem((int) (Math.random()*3));
//
//                            }
//                        });
//
//                    }
//                }).start();

            }

            @Override
            public void onPageScrollStateChanged(int state) {
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
                                viewPager.setCurrentItem((int) (Math.random()*3));

                            }
                        });

                    }
                }).start();
            }
        });


        //刷新
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

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
                              if(page>1){  --page;
                                String url_path=res_path+page;
                                HandlerJsonString handlerJsonString = new HandlerJsonString(handler);
                                handlerJsonString.downLoadJsonString(url_path);
                                myFragment11BaseAdapter.notifyDataSetChanged();
                                pullToRefreshListView.onRefreshComplete();
                              }
                            }
                        });

                    }
                }).start();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

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
                                String url_path=res_path+page;
                                HandlerJsonString handlerJsonString = new HandlerJsonString(handler);
                                handlerJsonString.downLoadJsonString(url_path);
                                myFragment11BaseAdapter.notifyDataSetChanged();//通知刷新
                                pullToRefreshListView.onRefreshComplete();


                            }
                        });

                    }
                }).start();
            }
        });

        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                //可以获得 pullToRefreshListView 的位置

//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        String string= DownLoadUtils.getJsonString(res_path);
//                        String strings=string.replace("280280","Second");
//                        String str=strings.replace("160120","Third");
//                        Gson gson=new Gson();
//                        ToBean toBean = gson.fromJson(str,ToBean.class);
//                        if(i%2==0){
//                             url=toBean.getSecond().get(i).getWeb_url();
//                        }else {
//                             url=toBean.getThird().get(i).getWeb_url();
//                        }
//
//                    }
//                }).start();
//                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));//启动自身的游览器
//                startActivity(intent);


//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        String string= DownLoadUtils.getJsonString(res_path);
//                        String strings=string.replace("280280","Second");
//                        String str=strings.replace("160120","Third");
//                        Gson gson=new Gson();
//                        ToBean toBean = gson.fromJson(str,ToBean.class);
////                        List<ToBean.SecondBean> secondBeen=toBean.getSecond();
////                        List<ToBean.ThirdBean> thirdBeen=toBean.getThird();
//                        if(i%5==0){
//                             url=toBean.getSecond().get(i).getWeb_url();
//                        }else {
//                             url=toBean.getThird().get(i).getWeb_url();
//                        }
//
////                        String url=secondBeen.get(i).getWeb_url();
//                        Intent intent=new Intent(getActivity(), MyWebActivity.class);
//                        intent.putExtra("gl",url);
//                        getActivity().startActivity(intent);
//
//                    }
//                }).start();




            }
        });






        return view;
    }





    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}
