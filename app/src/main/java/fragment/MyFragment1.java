package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geolei.day0903.R;

import java.util.ArrayList;
import java.util.List;

import Pageradapter.MyFragment11StarePageAdapter;

/**
 * Created by Administrator on 16-9-3.
 */
public class MyFragment1 extends Fragment implements ViewPager.OnPageChangeListener {


    ViewPager viewPager;
    List<Fragment> datas;
    MyFragment11StarePageAdapter adapter;

    HorizontalScrollView horizontalScrollView;
    LinearLayout linearLayout;
    View scrollview;


    public MyFragment1 getFragment() {
        MyFragment1 fragment1 = new MyFragment1();

        return fragment1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datas = new ArrayList<>();
//        datas.add(new MyFragment11());
//        datas.add(new MyFragment12());
//        datas.add(new MyFragment13());
//        datas.add(new MyFragment14());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.itme_fragment1, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        viewPager = (ViewPager) view.findViewById(R.id.fragment1ViewPagerId);
        horizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.horizontalScrollViewId);
        linearLayout = (LinearLayout) view.findViewById(R.id.linearlayoutId);
        scrollview = view.findViewById(R.id.viewId);


        adapter = new MyFragment11StarePageAdapter(getActivity().getSupportFragmentManager(), datas);
        viewPager.setAdapter(adapter);


        viewPager.setOnPageChangeListener(this);


        TextView text;
        for (int i = 0; i < linearLayout.getChildCount(); i++) {

            text = (TextView) linearLayout.getChildAt(i);
            text.setTag(i);

            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = (Integer) view.getTag();
                    viewPager.setCurrentItem(position);

                }
            });

        }


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) scrollview.getLayoutParams();
        params.leftMargin = (position + positionOffsetPixels) * scrollview.getWidth();
        scrollview.setLayoutParams(params);


    }

    @Override
    public void onPageSelected(int position) {
        TextView textView;

        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            //变色
        }

        textView = (TextView) linearLayout.getChildAt(position);
        int left = textView.getLeft();
        int displayWidth = getResources().getDisplayMetrics().widthPixels;//屏幕宽度
        int textWidth = textView.getWidth();
        int offset = left - displayWidth / 2 + textWidth / 2;
        horizontalScrollView.smoothScrollTo(offset, 0);


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
