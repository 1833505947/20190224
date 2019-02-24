package com.example.jinjiezhouermn_20190223.model;

import com.example.jinjiezhouermn_20190223.Contract;
import com.example.jinjiezhouermn_20190223.api.Api;
import com.example.jinjiezhouermn_20190223.api.UserService;
import com.example.jinjiezhouermn_20190223.entity.BaseBean;
import com.example.jinjiezhouermn_20190223.entity.ListBean;
import com.example.jinjiezhouermn_20190223.entity.XqBean;
import com.example.jinjiezhouermn_20190223.net.RetrofitCallback;
import com.example.jinjiezhouermn_20190223.util.RetrofitRxjavaUtil;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ListModel implements Contract.IModel {
    @Override
    public void getList(HashMap<String, String> map, final RetrofitCallback retrofitCallback) {
        UserService setretrofit = RetrofitRxjavaUtil.getInstance().setretrofit();
        setretrofit.getList(Api.SEARCH_URL,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseBean<List<ListBean>>>() {
            @Override
            public void accept(BaseBean<List<ListBean>> listBaseBean) throws Exception {
                List<ListBean> result = listBaseBean.result;
                retrofitCallback.SuccessList(result);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                retrofitCallback.FailList("请求失败");
            }
        });
    }

    @Override
    public void getXq(String id, final RetrofitCallback retrofitCallback) {
        UserService setretrofit = RetrofitRxjavaUtil.getInstance().setretrofit();
        setretrofit.getXq(Api.XQ_URL,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseBean<List<XqBean>>>() {
                    @Override
                    public void accept(BaseBean<List<XqBean>> listBaseBean) throws Exception {
                        List<XqBean> result = listBaseBean.result;
                        retrofitCallback.Successxq(result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        retrofitCallback.Failxq("请求失败");
                    }
                });
    }


}
