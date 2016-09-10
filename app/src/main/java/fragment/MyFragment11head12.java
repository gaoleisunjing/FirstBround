package fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.geolei.day0903.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;

import Bean.Title1;
import loader.DownLoadUtils;

/**
 * Created by Administrator on 16-9-4.
 */
public class MyFragment11head12 extends Fragment {


    String head_path = "http://api.fengniao.com/app_ipad/focus_pic.php?mid=19928?appImei=000000000000000&osType=Android&osVersion=4.1.1";
    ArrayList<Title1> list;
    Handler handler = new Handler();
    TextView textView;
    ImageView imageView;


    public MyFragment11head12 getFragment() {
        MyFragment11head12 myFragment11head1 = new MyFragment11head12();
        //有参数的话可以用来传值

        return myFragment11head1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mview = inflater.inflate(R.layout.item_fragment11hand1, container, false);
        textView = (TextView) mview.findViewById(R.id.headTitleTextViewId);
        imageView = (ImageView) mview.findViewById(R.id.headTitleImageId);


        new Thread(new Runnable() {
            @Override
            public void run() {
                String string = DownLoadUtils.getJsonString(head_path);
                Log.d("gl", "============title===============" + string);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Title1>>() {}.getType();
                list = gson.fromJson(string, type);
                Log.d("gl", "gson==list.size()=============" + list.size());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String title = list.get(1).getTitle();
                        textView.setText(title);
                        Log.d("gl", "=========text2的title" + title);
                        Picasso.with(getActivity()).load(list.get(1).getPic_src()).error(R.mipmap.ic_launcher).into(imageView);
                        //  arrayAdapter=new ArrayAdapter<Title1>(getActivity(),R.layout.item_fragment11hand1,list);

                    }
                });

            }
        }).start();

        return mview;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
