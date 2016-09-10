package Pageradapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 16-9-4.
 */
public class MyHandViewPagerAdapter extends FragmentStatePagerAdapter{


    List<Fragment> list;

    public MyHandViewPagerAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list=list;

    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
     //   Log.d("gl","size----"+list.size());
        return list.size();
    }
}
