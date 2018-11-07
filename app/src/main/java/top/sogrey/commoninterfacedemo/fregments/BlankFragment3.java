package top.sogrey.commoninterfacedemo.fregments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import top.sogrey.commoninterface.BaseFragment;
import top.sogrey.commoninterfacedemo.R;

public class BlankFragment3 extends BaseFragment {

    public BlankFragment3() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mViewRoot = inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
        mViewRoot.findViewById(R.id.btn_3).setOnClickListener(v->{
            onPressed();
        });
        return mViewRoot;
    }

    private void onPressed(){
//       Toast.makeText(container.getContext(),BlankFragment.class.getName(),Toast.LENGTH_LONG).show();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
