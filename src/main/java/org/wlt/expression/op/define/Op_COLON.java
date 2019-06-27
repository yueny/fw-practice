/**
 * 
 */
package org.wlt.expression.op.define;

import org.wlt.expression.IllegalExpressionException;
import org.wlt.expression.datameta.BaseDataMeta;
import org.wlt.expression.datameta.Constant;
import org.wlt.expression.op.IOperatorExecution;
import org.wlt.expression.op.Operator;

/**
 * @author 林良益，卓诗垚
 * @version 2.0 
 * 2009-02-06
 */
public class Op_COLON implements IOperatorExecution {

	public static final Operator THIS_OPERATOR = Operator.COLON;
	/* (non-Javadoc)
	 * @see IOperatorExecution#execute(Constant[])
	 */
	public Constant execute(Constant[] args) {
		throw new UnsupportedOperationException("操作符\"" + THIS_OPERATOR.getToken() + "不支持该方法");
	}

	/* (non-Javadoc)
	 * @see IOperatorExecution#verify(int, BaseDataMeta[])
	 */
	public Constant verify(int opPositin, BaseDataMeta[] args)
			throws IllegalExpressionException {
		throw new UnsupportedOperationException("操作符\"" + THIS_OPERATOR.getToken() + "不支持该方法");
	}


}
