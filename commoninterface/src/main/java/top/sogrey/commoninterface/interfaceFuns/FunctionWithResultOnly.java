package top.sogrey.commoninterface.interfaceFuns;

/**
 * 描述：
 * Created by Sogrey on 2018/11/7.
 */

public abstract class FunctionWithResultOnly<R> extends BaseInterfaceFunction {
    public FunctionWithResultOnly(String funName) {
        super(funName);
    }
    public abstract R function();
}
