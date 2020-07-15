package com.aper.ResponsibilityChain;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)，<script>欢迎访问这个网站，大家都是996");


        FilterChain filters = new FilterChain();
        filters.add(new HTMLFilter());
        filters.add(new SensitiveFilter());
        filters.doFilter(msg);

        System.out.println(msg);
    }
}

class Msg {
    String name;
    String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}

interface Filter {
    boolean doFilter(Msg msg);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace('<', '[');
        r = r.replace('>', ']');
        msg.setMsg(r);
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replaceAll("996", "955");
        msg.setMsg(r);
        return true;
    }
}

class FilterChain {
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    public boolean doFilter(Msg msg) {
        for (Filter f : filters) {
            if (!f.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }
}