package adpter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.geolei.day0903.MyWebActivity;
import com.geolei.day0903.R;
import com.squareup.picasso.Picasso;
import java.util.List;
import Bean.Study;

/**
 * Created by Administrator on 16-9-8.
 */
public class MyFragment14BaseAdapter extends BaseAdapter {

    List<Study.ListBean> listBeenList;
    Context context;

    public MyFragment14BaseAdapter(List<Study.ListBean> listBeenList, Context context) {
        this.listBeenList = listBeenList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listBeenList.size() / 2;
    }

    @Override
    public Object getItem(int i) {
        return listBeenList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        HolderView holderView = new HolderView();

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_fragment14adapter, null);

            holderView.imageView1 = (ImageView) view.findViewById(R.id.fragment14Image1Id);
            holderView.textView1 = (TextView) view.findViewById(R.id.fragment14TextView1Id);
            view.setTag(holderView);
        } else {
            holderView = (HolderView) view.getTag();
        }
        holderView.textView1.setText(listBeenList.get(i).getTitle());
        Log.d("ggl", "setTectView");
        Picasso.with(context).load(listBeenList.get(i).getPic_url()).error(R.mipmap.ic_launcher).into(holderView.imageView1);
        Log.d("ggl","setImageView");


        holderView.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=listBeenList.get(i).getWeb_url();
                Intent intent=new Intent(context, MyWebActivity.class);
                intent.putExtra("gl",url);
                context.startActivity(intent);

            }
        });


        return view;
    }


    public class HolderView {
        ImageView imageView1;
        TextView textView1;
    }

}