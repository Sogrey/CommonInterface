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
import top.sogrey.commoninterface.interfaceFuns.FunctionException;
import top.sogrey.commoninterface.interfaceFuns.FunctionManager;
import top.sogrey.commoninterfacedemo.MainActivity;
import top.sogrey.commoninterfacedemo.R;

public class BlankFragment extends BaseFragment {

    public static final String INTERFACE=BlankFragment.class.getName()+"_NRNP";
    private MainActivity mMainActivity;

    public BlankFragment() {
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
        mViewRoot = inflater.inflate(R.layout.fragment_blank, container, false);
        mViewRoot.findViewById(R.id.btn_1).setOnClickListener(v->{
            onPressed();
        });
        return mViewRoot;
    }

   private void onPressed(){
       try {
           mFunctionManager.invoke(INTERFACE);
       } catch (FunctionException e) {
           e.printStackTrace();
       }
   }

    @Override
    public void setmFunctionManager(FunctionManager mFunctionManager) {
        super.setmFunctionManager(mFunctionManager);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MainActivity){
            mMainActivity = (MainActivity)context;
            mMainActivity.setFunctions(BlankFragment.this.getTag());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
