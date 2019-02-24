package com.example.jinjiezhouermn_20190223;

import com.example.jinjiezhouermn_20190223.entity.ListBean;
import com.example.jinjiezhouermn_20190223.entity.XqBean;
import com.example.jinjiezhouermn_20190223.net.RetrofitCallback;

import java.util.HashMap;
import java.util.List;

public interface Contract {
    public abstract class IPersenter{
        public abstract void getList(HashMap<String,String> map);
        public abstract void getXq(String id);
    }
    interface IModel{
        void getList(HashMap<String,String> map, RetrofitCallback retrofitCallback);
        void getXq(String id, RetrofitCallback retrofitCallback);
    }
    interface IView{
        void Success(List<ListBean> list);
        void Fail(String msg);
        void SuccessXq(List<XqBean> xqBeans);
        void FailXq(String msg);
    }
}
