package com.java.jstl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * 格式化身份证号码
 *
 * 格式如下：
 * 310101 yyyy MMdd xxxx
 */
public class FormatIdNumber extends TagSupport {
    private String value;
    private String parttern;

    public FormatIdNumber() {}

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
        String newVal = String.format("%s %s %s %s",
                val.substring(0, 6),
                val.substring(6, 10),
                val.substring(10, 14),
                val.substring(14)
        );
        try {
            pageContext.getOut().write(newVal);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
}
