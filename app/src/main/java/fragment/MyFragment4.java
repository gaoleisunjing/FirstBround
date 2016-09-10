package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.geolei.day0903.Main4Activity;
import com.geolei.day0903.R;

/**
 * Created by Administrator on 16-9-3.
 */
public class MyFragment4 extends Fragment {

    RadioGroup radioGroup;
    RadioButton button1, button2, button3, button4, button5, button6, button7, button8;


    public MyFragment4 getFragment() {
        MyFragment4 fragment4 = new MyFragment4();


        return fragment4;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment4, null);

        radioGroup= (RadioGroup) view.findViewById(R.id.fragment4RadionGroupId);
        button1= (RadioButton) view.findViewById(R.id.fragment4RadioButton1Id);
        button2= (RadioButton) view.findViewById(R.id.fragment4RadioButton2Id);
        button3= (RadioButton) view.findViewById(R.id.fragment4RadioButton3Id);
        button4= (RadioButton) view.findViewById(R.id.fragment4RadioButton4Id);
        button5= (RadioButton) view.findViewById(R.id.fragment4RadioButton5Id);
        button6= (RadioButton) view.findViewById(R.id.fragment4RadioButton6Id);
        button7= (RadioButton) view.findViewById(R.id.fragment4RadioButton7Id);
        button8= (RadioButton) view.findViewById(R.id.fragment4RadioButton8Id);


     radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(RadioGroup radioGroup, int i) {
             switch (i){
                case R.id.fragment4RadioButton1Id:
          Intent intent=new Intent(getActivity(), Main4Activity.class);
             intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getActivity().startActivity(intent);


                     break;

                 case R.id.fragment4RadioButton2Id:

                     break;
                 case R.id.fragment4RadioButton3Id:

                     break;
                 case R.id.fragment4RadioButton4Id:

                     break;
                 case R.id.fragment4RadioButton5Id:

                     break;
                 case R.id.fragment4RadioButton6Id:

                     break;
                 case R.id.fragment4RadioButton7Id:

                     break;
                 case R.id.fragment4RadioButton8Id:

                     break;


             }
         }
     });


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

    }

}
