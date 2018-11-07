package top.sogrey.commoninterface.interfaceFuns;

/**
 * 描述：
 * Created by Sogrey on 2018/11/7.
 */

public abstract class FunctionWithoutParamsAndResult extends BaseInterfaceFunction {

    public FunctionWithoutParamsAndResult(String funName) {
        super(funName);
    }

    public abstract void function();
}
