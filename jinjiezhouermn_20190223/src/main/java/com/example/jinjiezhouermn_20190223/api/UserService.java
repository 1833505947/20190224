package com.example.jinjiezhouermn_20190223.api;

import com.example.jinjiezhouermn_20190223.entity.BaseBean;
import com.example.jinjiezhouermn_20190223.entity.ListBean;
import com.example.jinjiezhouermn_20190223.entity.XqBean;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface UserService {
    @GET
    Observable<BaseBean<List<ListBean>>> getList(@Url String url, @QueryMap HashMap<String,String> map);
    @GET
    Observable<BaseBean<List<XqBean>>> getXq(@Url String url, @Query("commodityId") String commodityId);
}
