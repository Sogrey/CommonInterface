package top.sogrey.commoninterface.interfaceFuns;

/**
 * 描述：
 * Created by Sogrey on 2018/11/7.
 */

public abstract class FunctionWithParamsAndResult<R,P> extends BaseInterfaceFunction {
    public FunctionWithParamsAndResult(String funName) {
        super(funName);
    }
    public abstract R function(P[] params);
}
