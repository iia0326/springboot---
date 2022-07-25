package com.kangyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class test {
    @RequestMapping("/text")
    public String error(){
        return "jsp/text";
    }

    @RequestMapping("/text2")
    public String html(){
        return "input";
    }

    @RequestMapping("/fx")
    public String fx(){
        return "redirect:http://bmfw.www.gov.cn/yqfxdjcx/risk.html";
    }

    @RequestMapping("/xck")
    public String xck(){
        return "redirect:https://xc.caict.ac.cn/#/login";
    }

    @RequestMapping("/xlxw")
    public String xlxw(){
        return "redirect:https://news.sina.cn/zt_d/yiqing0121";
    }
    @RequestMapping("/bdxw")
    public String bdxw(){
        return "redirect:https://voice.baidu.com/act/newpneumonia/newpneumonia";
    }


    @RequestMapping("/cx")
    public String cx(){
        return "redirect:http://www.gov.cn/zhuanti/2021yqfkgdzc/index.htm#/";
    }
}
