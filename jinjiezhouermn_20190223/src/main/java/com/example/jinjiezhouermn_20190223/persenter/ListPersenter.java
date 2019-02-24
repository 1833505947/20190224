package com.example.jinjiezhouermn_20190223.persenter;

import com.example.jinjiezhouermn_20190223.Contract;
import com.example.jinjiezhouermn_20190223.entity.ListBean;
import com.example.jinjiezhouermn_20190223.entity.XqBean;
import com.example.jinjiezhouermn_20190223.model.ListModel;
import com.example.jinjiezhouermn_20190223.net.RetrofitCallback;

import java.util.HashMap;
import java.util.List;

public class ListPersenter extends Contract.IPersenter {
    private ListModel listModel;
    private Contract.IView iView;

    public ListPersenter( Contract.IView iView) {
        this.listModel = new ListModel();
        this.iView = iView;
    }

    @Override
    public void getList(HashMap<String, String> map) {
        listModel.getList(map, new RetrofitCallback() {
            @Override
            public void SuccessList(List<ListBean> list) {
                iView.Success(list);
            }

            @Override
            public void FailList(String msg) {
                iView.Fail(msg);
            }

            @Override
            public void Successxq(List<XqBean> list) {

            }

            @Override
            public void Failxq(String msg) {

            }
        });
    }

    @Override
    public void getXq(String id) {
        listModel.getXq(id, new RetrofitCallback() {

            @Override
            public void SuccessList(List<ListBean> list) {

            }

            @Override
            public void FailList(String msg) {

            }

            @Override
            public void Successxq(List<XqBean> list) {
                iView.SuccessXq(list);
            }

            @Override
            public void Failxq(String msg) {
                iView.FailXq(msg);
            }
        });
    }


}
