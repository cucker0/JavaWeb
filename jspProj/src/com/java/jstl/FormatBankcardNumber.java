package com.java.jstl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * 格式化银行卡号
 * 格式如下：
 * xxxx xxxx xxxx xxxx xxx
 */
public class FormatBankcardNumber extends TagSupport {
    private String value;
    private String parttern;

    public FormatBankcardNumber() {}

    // 方法

    public void setValue(String value) {
        this.value = value;
    }

    public void setParttern(String parttern) {
        this.parttern = parttern;
    }

    @Override
    public int doStartTag() throws JspException {
        String val = String.valueOf(value).strip();
        StringBuilder sb = new StringBuilder(val);

        for (int i = (val.length() / 4); i >0 ; --i) {
            sb.insert(4 * i, " ");
        }
        try {
            pageContext.getOut().write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
}
