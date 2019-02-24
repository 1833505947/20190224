package com.example.jinjiezhouermn_20190223.net;

import com.example.jinjiezhouermn_20190223.entity.ListBean;
import com.example.jinjiezhouermn_20190223.entity.XqBean;

import java.util.List;

public interface RetrofitCallback {
    void SuccessList(List<ListBean> list);
    void FailList(String msg);
    void Successxq(List<XqBean> list);
    void Failxq(String msg);
}
