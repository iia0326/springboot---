package com.kangyi.config;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

public class HandleResourceViewExists  extends InternalResourceView {
    @Override
    public boolean checkResource(Locale locale) {
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
        System.out.println("—!!!!!—找页面"+" : "+getUrl());
        return file.exists(); //判断页面是否存在
    }
}
