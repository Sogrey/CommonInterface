package top.sogrey.commoninterfacedemo.fregments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import top.sogrey.commoninterface.BaseFragment;
import top.sogrey.commoninterface.interfaceFuns.FunctionException;
import top.sogrey.commoninterface.interfaceFuns.FunctionManager;
import top.sogrey.commoninterfacedemo.MainActivity;
import top.sogrey.commoninterfacedemo.R;

public class BlankFragment2 extends BaseFragment {
    public static final String INTERFACE = BlankFragment.class.getName() + "_YRYP";
    private MainActivity mMainActivity;

    public BlankFragment2() {
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
        mViewRoot = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        mViewRoot.findViewById(R.id.btn_2).setOnClickListener(v -> {
            onPressed();
        });
        TextView tv = new TextView(container.getContext());
        return mViewRoot;
    }

    private void onPressed() {
        try {
            String result = mFunctionManager.invokeYRYP(INTERFACE, new String[]{"发给Mainactivity的参数","ddd"});
            Toast.makeText(mMainActivity, result, Toast.LENGTH_LONG).show();
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
        if (context instanceof MainActivity) {
            mMainActivity = (MainActivity) context;
            mMainActivity.setFunctions(BlankFragment2.this.getTag());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
