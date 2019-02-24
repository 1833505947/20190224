package com.example.jinjiezhouermn_20190223;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.jinjiezhouermn_20190223.entity.ListBean;
import com.example.jinjiezhouermn_20190223.entity.XqBean;
import com.example.jinjiezhouermn_20190223.persenter.ListPersenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;

public class XqActivity extends AppCompatActivity implements Contract.IView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xq);
        ListPersenter listPersenter = new ListPersenter(this);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Toast.makeText(this,"id:"+id,Toast.LENGTH_SHORT).show();
        /*HashMap<String, String> map = new HashMap<String, String>();
        map.put("commodityId",id);*/

        listPersenter.getXq(id);

    }

    @Override
    public void Success(List<ListBean> list) {

    }

    @Override
    public void Fail(String msg) {

    }

    @Override
    public void SuccessXq(List<XqBean> xqBeans) {
        Toast.makeText(this,"xq请求成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void FailXq(String msg) {
        Toast.makeText(this,"xq请求失败",Toast.LENGTH_SHORT).show();
    }
}
