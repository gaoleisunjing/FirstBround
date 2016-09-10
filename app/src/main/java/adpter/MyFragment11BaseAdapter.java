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

import com.geolei.day0903.Main2Activity;
import com.geolei.day0903.MyWebActivity;
import com.geolei.day0903.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Bean.ToBean;

/**
 * Created by Administrator on 16-9-5.
 */
public class MyFragment11BaseAdapter extends BaseAdapter {

    List<ToBean.SecondBean> secondBeen;
    List<ToBean.ThirdBean> thirdBeen;

    final int TYPE_1 = 0;
    final int TYPE_2 = 1;
    Context context;

    List<ToBean> list;


    public MyFragment11BaseAdapter(List<ToBean.SecondBean> secondBeen, List<ToBean.ThirdBean> thirdBeen, Context context) {
        this.secondBeen = secondBeen;
        this.thirdBeen = thirdBeen;
        this.context = context;

    }

    public MyFragment11BaseAdapter(List<ToBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;

        // return list.size();
    }

    @Override
    public Object getItem(int i) {
        if (i % 2 == 0) {
            return secondBeen;
        } else {
            return thirdBeen.get(i - 1);
        }

        //  return  list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public int getItemViewType(int position) {

        if (position % 2 == 0)
            return TYPE_1;
        else
            return TYPE_2;

    }

    @Override
    public int getViewTypeCount() {

        return 2;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        HolderView1 holderView1 = null;
        HolderView2 holderView2 = null;
        int type = getItemViewType(i);
        if (view == null) {

            switch (type) {

                case TYPE_1:
                    view = LayoutInflater.from(context).inflate(R.layout.item_fragment11baseadapter1, viewGroup, false);
                    holderView1 = new HolderView1();
                    holderView1.imageView11 = (ImageView) view.findViewById(R.id.image1FragmentBaseAdapterId);
                    holderView1.imageView12 = (ImageView) view.findViewById(R.id.image2FragmentBaseAdapterId);
                    holderView1.textView11 = (TextView) view.findViewById(R.id.text1FragmentBaseAdapterId);
                    holderView1.textView12 = (TextView) view.findViewById(R.id.text2FragmentBaseAdapterId);

                    view.setTag(holderView1);

                    break;
                case TYPE_2:
                    view = LayoutInflater.from(context).inflate(R.layout.item_fragment11baseadapter2, viewGroup, false);
                    holderView2 = new HolderView2();
                    holderView2.imageView21 = (ImageView) view.findViewById(R.id.image1FragmentBaseAdapter2Id);
                    holderView2.imageView22 = (ImageView) view.findViewById(R.id.image2FragmentBaseAdapter2Id);
                    holderView2.imageView23 = (ImageView) view.findViewById(R.id.image3FragmentBaseAdapter2Id);
                    holderView2.imageView24 = (ImageView) view.findViewById(R.id.image4FragmentBaseAdapter2Id);


                    holderView2.textView21 = (TextView) view.findViewById(R.id.text11FragmentBaseAdapter2Id);
                    holderView2.textView211 = (TextView) view.findViewById(R.id.text12FragmentBaseAdapter2Id);
                    holderView2.textView22 = (TextView) view.findViewById(R.id.text21FragmentBaseAdapter2Id);
                    holderView2.textView222 = (TextView) view.findViewById(R.id.text22FragmentBaseAdapter2Id);
                    holderView2.textView23 = (TextView) view.findViewById(R.id.text31FragmentBaseAdapter2Id);
                    holderView2.textView233 = (TextView) view.findViewById(R.id.text32FragmentBaseAdapter2Id);
                    holderView2.textView24 = (TextView) view.findViewById(R.id.text41FragmentBaseAdapter2Id);
                    holderView2.textView244 = (TextView) view.findViewById(R.id.text42FragmentBaseAdapter2Id);


                    view.setTag(holderView2);
                    break;
            }

        } else {
            switch (type) {

                case TYPE_1:

                    holderView1 = (HolderView1) view.getTag();
                    break;

                case TYPE_2:
                    holderView2 = (HolderView2) view.getTag();

                    break;

            }
        }
        switch (type) {
            //设置资源
            case TYPE_1:

                holderView1.textView11.setText("ggggg");


                holderView1.textView11.setText(secondBeen.get(i).getTitle());
                // Log.d("gl", "==============" + secondBeen.get(i * 2 / 5).getTitle());
                holderView1.textView12.setText(secondBeen.get(i+1).getTitle());
                // Log.d("gl", "==============holderView.textView12===可用====" + holderView1.textView12.getText());
                String image_path = secondBeen.get(i).getPic_url();
                String image_path2 = secondBeen.get(i+1).getPic_url();
                // Log.d("gl", "image_Path2==============" + image_path2);
                // Log.d("gl", "=============可以过来么" + holderView1.imageView11);
                Picasso.with(context).load(image_path).resize(100, 100).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holderView1.imageView11);
                // Log.d("gl", "=============可以过来么");
                Log.d("gl", "postition========" + i);
                Picasso.with(context).load(image_path2).resize(100, 100).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holderView1.imageView12);
                // Log.d("gl", "=============可以过来么222" + holderView1.imageView12);


                holderView1.imageView11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url=secondBeen.get(0).getWeb_url();
                    Intent intent=new Intent(context, MyWebActivity.class);
                    intent.putExtra("gl",url);
                    context.startActivity(intent);

                    }
                });

                holderView1.imageView12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url=secondBeen.get(1).getWeb_url();
                        Intent intent=new Intent(context, MyWebActivity.class);
                        intent.putExtra("gl",url);
                        context.startActivity(intent);

                    }
                });


                break;

            case TYPE_2:

                holderView2.textView21.setText(thirdBeen.get(i-1).getTitle());
                Log.d("gl", "postition=========" + i);

                holderView2.textView211.setText(thirdBeen.get(i-1).getDate());
                String images_path1 = thirdBeen.get(i-1).getPic_url();
                Picasso.with(context).load(images_path1).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holderView2.imageView21);


                holderView2.textView22.setText(thirdBeen.get(i).getTitle());
                holderView2.textView222.setText(thirdBeen.get(i).getDate());
                String images_path2 = thirdBeen.get(i).getPic_url();
                Picasso.with(context).load(images_path2).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holderView2.imageView22);


                holderView2.textView23.setText(thirdBeen.get(i+1).getTitle());
                holderView2.textView233.setText(thirdBeen.get(i+1).getDate());
                String images_path3 = thirdBeen.get(i+1).getPic_url();
                Picasso.with(context).load(images_path3).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holderView2.imageView23);


                holderView2.textView24.setText(thirdBeen.get(i+2).getTitle());
                holderView2.textView244.setText(thirdBeen.get(i+2).getDate());
                String images_path4 = thirdBeen.get(i+2).getPic_url();
                Picasso.with(context).load(images_path4).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holderView2.imageView24);


                Log.d("gl", "===============这个可以过来麽");

                holderView2.imageView21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String url=thirdBeen.get(0).getWeb_url();
                        Intent intent=new Intent(context, MyWebActivity.class);
                        intent.putExtra("gl",url);
                        context.startActivity(intent);
                    }
                });
                holderView2.imageView22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String url=thirdBeen.get(1).getWeb_url();
                        Intent intent=new Intent(context, MyWebActivity.class);
                        intent.putExtra("gl",url);
                        context.startActivity(intent);
                    }
                });
                holderView2.imageView23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String url=thirdBeen.get(2).getWeb_url();
                        Intent intent=new Intent(context, MyWebActivity.class);
                        intent.putExtra("gl",url);
                        context.startActivity(intent);
                    }
                });
                holderView2.imageView24.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String url=thirdBeen.get(3).getWeb_url();
                        Intent intent=new Intent(context, MyWebActivity.class);
                        intent.putExtra("gl",url);
                        context.startActivity(intent);
                    }
                });



                break;

        }


        return view;
    }


//        int type = getItemViewType(i);
//        HolderView1 holderView1 = null;
//        HolderView2 holderView2 = null;
//        switch (type) {
//
//            case TYPE_1:
//                if (view==null) {
//                    view = LayoutInflater.from(context).inflate(R.layout.item_fragment11baseadapter1, null);
//                    holderView1 = new HolderView1();
//                    holderView1.imageView11 = (ImageView) view.findViewById(R.id.image1FragmentBaseAdapterId);
//                    holderView1.imageView12 = (ImageView) view.findViewById(R.id.image1FragmentBaseAdapter2Id);
//                    holderView1.textView11 = (TextView) view.findViewById(R.id.text1FragmentBaseAdapterId);
//                    holderView1.textView12 = (TextView) view.findViewById(R.id.text2FragmentBaseAdapterId);
//                    view.setTag(holderView1);
//
//                } else {
//                     holderView1= (HolderView1) view.getTag();
//
//                }
//
//                holderView1.textView11.setText("ggggg");
//
//               Log.d("gl","==============gggg");
//
//                holderView1.textView11.setText(secondBeen.get(0).getTitle());
//                Log.d("gl","=============="+secondBeen.get(0).getTitle());
//                holderView1.textView12.setText(thirdBeen.get(1).getTitle());
//
//                String image_path=secondBeen.get(0).getPic_url();
//                String image_path2=secondBeen.get(1).getPic_url();
//                Picasso.with(context).load(image_path).into(holderView1.imageView11);
//                Picasso.with(context).load(image_path2).into(holderView1.imageView12);
//
//                break;
//            case TYPE_2:
//                if (view==null){
//                    view = LayoutInflater.from(context).inflate(R.layout.item_fragment11baseadapter2, null);
//                    holderView2 = new HolderView2();
//                    holderView2.imageView21 = (ImageView) view.findViewById(R.id.image1FragmentBaseAdapter2Id);
//                    holderView2.textView21 = (TextView) view.findViewById(R.id.text11FragmentBaseAdapter2Id);
//                    holderView2.textView211 = (TextView) view.findViewById(R.id.text12FragmentBaseAdapter2Id);
//                     view.setTag(holderView2);
//                } else{
//                    holderView2= (HolderView2) view.getTag();
//                }
//                holderView2.textView211.setText(thirdBeen.get(i-1).getTitle());
//                holderView2.textView21.setText(thirdBeen.get(i-1).getDate());
//                String images_path=thirdBeen.get(i-1).getPic_url();
//                Picasso.with(context).load(images_path).into(holderView2.imageView21);
//
//
//                break;
//            default:
//                break;
//        }
//        return view;
//    }

    public class HolderView1 {
        ImageView imageView11, imageView12;
        TextView textView11, textView12;
    }

    public class HolderView2 {
        ImageView imageView21, imageView22, imageView23, imageView24;
        TextView textView21, textView211, textView22, textView222, textView23, textView233, textView24, textView244;

    }
}
