package top.sogrey.commoninterface;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import top.sogrey.commoninterface.interfaceFuns.FunctionManager;

public class BaseFragment extends Fragment {
protected FunctionManager mFunctionManager;
   protected View mViewRoot;
    public BaseFragment() {
        // Required empty public constructor
    }

    public void setmFunctionManager(FunctionManager mFunctionManager) {
        this.mFunctionManager = mFunctionManager;
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
