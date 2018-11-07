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
    private HashMap<String, FunctionWithResultOnly> FunctionWithResultOnly;

    private FunctionManager() {
        mFunctionWithoutParamsAndResultMap = new HashMap<>();
        mFunctionWithParamsAndResultMap = new HashMap<>();
        mFunctionWithParamsOnlyMap = new HashMap<>();
        FunctionWithResultOnly = new HashMap<>();
    }

    public static FunctionManager getInstance() {
        if (_instance == null) {
            _instance = new FunctionManager();
        }
        return _instance;
    }

    public FunctionManager addFunction(FunctionWithoutParamsAndResult function) {
        mFunctionWithoutParamsAndResultMap.put(function.funName, function);
        return this;
    }

    public FunctionManager addFunction(FunctionWithParamsAndResult function) {
        mFunctionWithParamsAndResultMap.put(function.funName, function);
        return this;
    }

    public FunctionManager addFunction(FunctionWithParamsOnly function) {
        mFunctionWithParamsOnlyMap.put(function.funName, function);
        return this;
    }

    public FunctionManager addFunction(FunctionWithResultOnly function) {
        FunctionWithResultOnly.put(function.funName, function);
        return this;
    }

    public void invokeNRNP(String funName) throws FunctionException {
        if(TextUtils.isEmpty(funName)) return;
        if(mFunctionWithoutParamsAndResultMap!=null){
            FunctionWithoutParamsAndResult fun = mFunctionWithoutParamsAndResultMap.get(funName);
            if(fun!=null) fun.function();
            else throw new FunctionException("Has no this function:"+funName+".");
        }
    }
    public <R,P> R invokeYRYP(String funName, P[] params) throws FunctionException {
        if(TextUtils.isEmpty(funName)) return null;
        if(mFunctionWithParamsAndResultMap!=null){
            FunctionWithParamsAndResult fun = mFunctionWithParamsAndResultMap.get(funName);
            if(fun!=null) return (R) fun.function(params);
            else throw new FunctionException("Has no this function:"+funName+".");
        }
        return null;
    }

}
