package top.sogrey.commoninterface.interfaceFuns;

/**
 * 描述：
 * Created by Sogrey on 2018/11/7.
 */

public abstract class FunctionWithParamsOnly<P> extends BaseInterfaceFunction {
    public FunctionWithParamsOnly(String funName) {
        super(funName);
    }
    public abstract void function(P[] params);
}
