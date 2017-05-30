package com.cxg.interactiveweb.tools;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.beetl.core.Context;
import org.beetl.core.Function;

public class MoneyFormat implements Function {

    @Override
    public Object call(Object[] para, Context arg1) {
        NumberFormat nf = new DecimalFormat("#,##0.00");

        Object paramoney = "0";
        String testStr = "";
        paramoney = para[0];
        if (paramoney != null) {
            BigDecimal money = new BigDecimal(paramoney.toString()); // 传入时间
            testStr = nf.format(money);
        } else {
            BigDecimal money = new BigDecimal(0); // 传入时间
            testStr = nf.format(money);

        }

        return testStr;
    }

}
