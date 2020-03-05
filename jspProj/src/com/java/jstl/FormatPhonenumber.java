package com.java.jstl;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * 对手机号字符串格式化
 * 如:
 * 1xx xxxx xxxx
 */
public class FormatPhonenumber extends TagSupport{
    private String value;
    private String parttern;

    public FormatPhonenumber() {}

    // 方法
    public void setValue(String value) {
        this.value = value;
    }

    public void setParttern(String parttern) {
        this.parttern = parttern;
    }

    @Override
    public int doStartTag() throws JspException {
        String val = String.valueOf(value);
        String newVal = String.format("%s %s %s", val.substring(0, 3), val.substring(3, 7), val.substring(7));
        try {
            pageContext.getOut().write(newVal);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
}