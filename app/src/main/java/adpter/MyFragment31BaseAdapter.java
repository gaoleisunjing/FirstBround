package adpter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.geolei.day0903.MyWebActivity;
import com.geolei.day0903.R;
import java.util.List;
import Bean3.BBS;

/**
 * Created by Administrator on 16-9-8.
 */
public class MyFragment31BaseAdapter extends BaseAdapter {

    List<BBS.ListBean> listBeen;
    Context context;

    public MyFragment31BaseAdapter(List<BBS.ListBean> listBeen, Context context) {
        this.listBeen = listBeen;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return listBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        HolderView holderView = new HolderView();

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_fragment31adapter, null);
            holderView.textView1 = (TextView) view.findViewById(R.id.fragment31Textview1Id);
            holderView.textView2 = (TextView) view.findViewById(R.id.fragment31TextView2Id);
            holderView.textView3 = (TextView) view.findViewById(R.id.fragment31TextView3Id);

            view.setTag(holderView);
        } else {
            holderView = (HolderView) view.getTag();
        }
        holderView.textView1.setText(listBeen.get(i).getTitle());
        Log.d("ggl", "setTectView");
        holderView.textView2.setText(listBeen.get(i).getAuthor());
        holderView.textView3.setText(listBeen.get(i).getReply());


        holderView.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=listBeen.get(i).getWeb_url();
                Intent intent=new Intent(context, MyWebActivity.class);
                intent.putExtra("gl",url);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
        holderView.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=listBeen.get(i).getDoc_url();
                Intent intent=new Intent(context, MyWebActivity.class);
                intent.putExtra("gl",url);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
        holderView.textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=listBeen.get(i).getWeb_url();
                Intent intent=new Intent(context, MyWebActivity.class);
                intent.putExtra("gl",url);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //解决Content的startActivity方法，需要开启一个新的task。
               // 如果使用 Activity的startActivity方法，不会有任何限制，因为Activity继承自Context，已重载了startActivity方法
                context.startActivity(intent);

            }
        });

        return view;
    }

    public class HolderView {
        TextView textView1,textView2,textView3;
    }

}
