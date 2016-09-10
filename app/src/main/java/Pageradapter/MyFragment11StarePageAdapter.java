package Pageradapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 16-9-3.
 */
public class MyFragment11StarePageAdapter extends FragmentStatePagerAdapter{

    List<Fragment> list;

    public MyFragment11StarePageAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list=list;

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
