package top.sogrey.commoninterface.interfaceFuns;

import android.text.TextUtils;

import java.util.HashMap;

import top.sogrey.commoninterface.R;

/**
 * 描述：
 * Created by Sogrey on 2018/11/7.
 */

public class FunctionManager {
    private static FunctionManager _instance;
    private HashMap<String, FunctionWithoutParamsAndResult> mFunctionWithoutParamsAndResultMap;
    private HashMap<String, FunctionWithParamsAndResult> mFunctionWithParamsAndResultMap;
    private HashMap<String, FunctionWithParamsOnly> mFunctionWithParamsOnlyMap;
    private HashMap<String, FunctionWithResultOnly> mFunctionWithResultOnly;

    private FunctionManager() {
        mFunctionWithoutParamsAndResultMap = new HashMap<>();
        mFunctionWithParamsAndResultMap = new HashMap<>();
        mFunctionWithParamsOnlyMap = new HashMap<>();
        mFunctionWithResultOnly = new HashMap<>();
    }

    public static FunctionManager getInstance() {
        if (_instance == null) {
            _instance = new FunctionManager();
        }
        return _instance;
    }


    public FunctionManager addFunction(BaseInterfaceFunction function) {
        if(function instanceof FunctionWithoutParamsAndResult){
            FunctionWithoutParamsAndResult f = (FunctionWithoutParamsAndResult) function;
            mFunctionWithoutParamsAndResultMap.put(function.funName, f);
        }
        if(function instanceof FunctionWithParamsAndResult){
            FunctionWithParamsAndResult f = (FunctionWithParamsAndResult) function;
            mFunctionWithParamsAndResultMap.put(function.funName, f);
        }
        if(function instanceof FunctionWithParamsOnly){
            FunctionWithParamsOnly f = (FunctionWithParamsOnly) function;
            mFunctionWithParamsOnlyMap.put(function.funName, f);
        }
        if(function instanceof FunctionWithResultOnly){
            FunctionWithResultOnly f = (FunctionWithResultOnly) function;
            mFunctionWithResultOnly.put(function.funName, f);
        }
        return this;
    }

    public void invoke(String funName) throws FunctionException {
        if (TextUtils.isEmpty(funName)) return;
        if (mFunctionWithoutParamsAndResultMap != null) {
            FunctionWithoutParamsAndResult fun = mFunctionWithoutParamsAndResultMap.get(funName);
            if (fun != null) fun.function();
            else throw new FunctionException("Has no this function:" + funName + ".");
        }
    }

    public <R, P> R invoke(String funName, P[] params, Class<R> c) throws FunctionException {
        if (TextUtils.isEmpty(funName)) return null;
        if (mFunctionWithParamsAndResultMap != null) {
            FunctionWithParamsAndResult fun = mFunctionWithParamsAndResultMap.get(funName);
            if (fun != null)
                if (c != null) {
                    return c.cast(fun.function(params));
                } else {
                    return (R) fun.function(params);
                }
            else throw new FunctionException("Has no this function:" + funName + ".");
        }
        return null;
    }

    public <P> void invoke(String funName, P[] params) throws FunctionException {
        if (TextUtils.isEmpty(funName)) return;
        if (mFunctionWithParamsOnlyMap != null) {
            FunctionWithParamsOnly fun = mFunctionWithParamsOnlyMap.get(funName);
            if (fun != null) fun.function(params);
            else throw new FunctionException("Has no this function:" + funName + ".");
        }
        return;
    }

    public <R> R invoke(String funName, Class<R> c) throws FunctionException {
        if (TextUtils.isEmpty(funName)) return null;
        if (mFunctionWithResultOnly != null) {
            FunctionWithResultOnly fun = mFunctionWithResultOnly.get(funName);
            if (fun != null) {
                if (c != null) {
                    return c.cast(fun.function());
                } else {
                    return (R) fun.function();
                }
            } else throw new FunctionException("Has no this function:" + funName + ".");
        }
        return null;
    }
}
