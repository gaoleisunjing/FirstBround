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

import Bean.Instraction;

/**
 * Created by Administrator on 16-9-7.
 */
public class MyFragment12BaseAdapter extends BaseAdapter {

    List<Instraction.ListBean> listBeen;
    Context context;

    public MyFragment12BaseAdapter(List<Instraction.ListBean> listBeen, Context context) {
        this.listBeen = listBeen;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listBeen.size()/2;
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
            view = LayoutInflater.from(context).inflate(R.layout.item_frgament12adapter,null);

            holderView.imageView1 = (ImageView) view.findViewById(R.id.fragment12Image1Id);
     //       holderView.imageView2 = (ImageView) view.findViewById(R.id.fragment12Image2Id);
            holderView.textView1 = (TextView) view.findViewById(R.id.fragment12TextView1Id);
     //      holderView.textView2 = (TextView) view.findViewById(R.id.fragment12TextView2Id);

            view.setTag(holderView);

        } else {
           holderView= (HolderView) view.getTag();

        }

        Log.d("ggl","=============holderView"+holderView);
        Log.d("ggl","=============textview"+holderView.textView1);
        Log.d("ggl","============="+listBeen.get(i).getTitle());
        holderView.textView1.setText(listBeen.get(i).getTitle());
        Log.d("ggl","setTectView");
  //      holderView.textView2.setText(listBeen.get(i+1).getTitle());
        Picasso.with(context).load(listBeen.get(i).getPic_url()).error(R.mipmap.ic_launcher).into(holderView.imageView1);
 //       Picasso.with(context).load(listBeen.get(i+1).getPic_url()).error(R.mipmap.ic_launcher).into(holderView.imageView2);


        holderView.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=listBeen.get(i).getWeb_url();
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
