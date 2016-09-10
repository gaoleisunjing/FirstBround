package adaptertitle;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.geolei.day0903.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Bean.Title1;

/**
 * Created by Administrator on 16-9-8.
 */
public class MytitleBaseAdapter  extends BaseAdapter{

    List<Title1> list;
    Context context;

    public MytitleBaseAdapter(List<Title1> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HolderView holderView=null;
        if(view==null){
         view= LayoutInflater.from(context).inflate(R.layout.item_fragment11hand1,null);
           holderView=new HolderView();
            holderView.textView= (TextView) view.findViewById(R.id.headTitleTextViewId);
            holderView.textView= (TextView) view.findViewById(R.id.headTitleImageId);

            view.setTag(holderView);
        }else{
            holderView= (HolderView) view.getTag();
        }

        holderView.textView.setText(list.get(i).getTitle());
        Log.d("wo","===========title1"+list.get(i).getTitle());
        Picasso.with(context).load(list.get(i).getPic_src()).error(R.mipmap.ic_launcher).into(holderView.imageView);
        Log.d("wo","===============完毕");
        return view;
    }

    class  HolderView{
        TextView textView;
        ImageView imageView;
    }

}
