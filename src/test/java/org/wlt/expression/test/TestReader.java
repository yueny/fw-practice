/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package org.wlt.expression.test;

import junit.framework.Assert;
import org.testng.annotations.Test;
import org.wlt.expression.ExpressionContext;
import org.wlt.expression.ExpressionExecutor;
import org.wlt.expression.ExpressionToken;
import org.wlt.expression.IllegalExpressionException;

import java.util.List;

/**
 *
 * @author dalong.wdl
 * @version $Id: TestReader.java, v 0.1 2017年12月19日 下午8:16 dalong.wdl Exp $
 */
public class TestReader {

    @Test
    public void testReader() throws IllegalExpressionException {
        ExpressionContext ctx = new ExpressionContext(){
            public Object bindObject(String name){
                //LoggerUtil.info(LOGGER, "表达式求值:" + name);
                return null;
            }
        };

        ExpressionExecutor ee = new ExpressionExecutor(ctx);

        List<ExpressionToken> tt = ee.analyze("__a.b.c + aa");

        Assert.assertNotNull(tt);
    }
}