package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.geolei.day0903.Main3Activity;
import com.geolei.day0903.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-9-3.
 */
public class MyFragment3 extends Fragment {


    RadioGroup radioGroup;
    RadioButton button1, button2, button3, button4, button5, button6, button7;
    ListView listView;
   // List<String> title1 = new ArrayList<>();
    String[] title1={"热帖","精华贴","最新贴","最新回复"};
    String[] title2={"人物","风光","纪实","人体","儿童","人体","建筑","生态","宠物"};
    String[] title3={"商业","女性视觉","新手","数码","黑白","实验","生活摄影","高校","手机","葡萄酒"};
    String[] title4={"交易警示","二手交易","器材维修"};
    String[] title5={"北京","上海","武汉"};
    String[] title6={"单反和镜头","大中画幅","便携数码"};
    String[] title7={"活动区","网友服务","蜂鸟茶馆"};

    ArrayAdapter<String> adapter;


    public MyFragment3 getFragment() {
        MyFragment3 fragment3 = new MyFragment3();


        return fragment3;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment3, null);
        radioGroup = (RadioGroup) view.findViewById(R.id.fragment3RadionGroupId);
        button1 = (RadioButton) view.findViewById(R.id.fragment3RadioButton1Id);
        button2 = (RadioButton) view.findViewById(R.id.fragment3RadioButton2Id);
        button3 = (RadioButton) view.findViewById(R.id.fragment3RadioButton3Id);
        button4 = (RadioButton) view.findViewById(R.id.fragment3RadioButton4Id);
        button5 = (RadioButton) view.findViewById(R.id.fragment3RadioButton5Id);
        button6 = (RadioButton) view.findViewById(R.id.fragment3RadioButton6Id);
        button7 = (RadioButton) view.findViewById(R.id.fragment3RadioButton7Id);
        listView = (ListView) view.findViewById(R.id.fragment3ListViewId);
//        adapter = new ArrayAdapter<String>(getActivity(), R.layout.item_fragment33, title1);//66666
        //listView.setAdapter(adapter);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.fragment3RadioButton1Id:
                        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), R.layout.item_fragment33, title1);
                        listView.setAdapter(adapter);
//                        title1.add("热帖");
//                        title1.add("精华贴");
//                        title1.add("最新贴");
//                        title1.add("最新回复");
//                        listView.setAdapter(adapter);
//                        title1.clear();
                       // adapter.clear();
                       // adapter.notifyDataSetChanged();
                        break;
                    case R.id.fragment3RadioButton2Id:
                    ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getActivity(), R.layout.item_fragment33, title2);
                        listView.setAdapter(adapter1);
                        break;
                    case R.id.fragment3RadioButton3Id:
                        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(getActivity(), R.layout.item_fragment33, title3);
                        listView.setAdapter(adapter2);
                        break;
                    case R.id.fragment3RadioButton4Id:
                        ArrayAdapter<String> adapter3=new ArrayAdapter<String>(getActivity(), R.layout.item_fragment33, title4);
                        listView.setAdapter(adapter3);
                        break;
                    case R.id.fragment3RadioButton5Id:
                        ArrayAdapter<String> adapter4=new ArrayAdapter<String>(getActivity(), R.layout.item_fragment33, title5);
                        listView.setAdapter(adapter4);
                        break;
                    case R.id.fragment3RadioButton6Id:
                        ArrayAdapter<String> adapter5=new ArrayAdapter<String>(getActivity(), R.layout.item_fragment33, title6);
                        listView.setAdapter(adapter5);
                        break;
                    case R.id.fragment3RadioButton7Id:
                        ArrayAdapter<String> adapter6=new ArrayAdapter<String>(getActivity(), R.layout.item_fragment33, title7);
                        listView.setAdapter(adapter6);
                        break;
                }

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=new Intent(getActivity(),Main3Activity.class);
                getActivity().startActivity(intent);



            }
        });



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

    }

}
