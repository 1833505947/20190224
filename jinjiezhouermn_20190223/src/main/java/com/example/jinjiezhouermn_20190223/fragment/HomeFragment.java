package com.example.jinjiezhouermn_20190223.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.jinjiezhouermn_20190223.Contract;
import com.example.jinjiezhouermn_20190223.R;
import com.example.jinjiezhouermn_20190223.adapter.ListAdapter;
import com.example.jinjiezhouermn_20190223.entity.ListBean;
import com.example.jinjiezhouermn_20190223.entity.XqBean;
import com.example.jinjiezhouermn_20190223.persenter.ListPersenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment implements Contract.IView,XRecyclerView.LoadingListener {

    private XRecyclerView xrc;
    private EditText keyword;
    private Button search;
    private ListPersenter listPersenter;
    private int page = 1;
private int count = 10;
    private List<ListBean> listBeans;
    private ListAdapter listAdapter;
    private ImageView img;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.homefragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        xrc =view.findViewById(R.id.xrc);
        xrc.setLoadingListener(this);
        listBeans = new ArrayList<>();
        img = view.findViewById(R.id.img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.pop_layout, null);
                PopupWindow popupWindow = new PopupWindow(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setContentView(inflate);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.BLUE));
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAsDropDown(inflate,200,200);

            }
        });
        keyword = view.findViewById(R.id.keyword);
        search = view.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = keyword.getText().toString();
                HashMap<String, String> map = new HashMap<>();
                map.put("keyword",s);

                /*map.put("labelId","1002");*/
                map.put("page",page+"");
                map.put("count",count+"");
                listPersenter.getList(map);
            }
        });
        listPersenter = new ListPersenter(this);

        initData();
    }

    private void initData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("keyword","板鞋");

        /*map.put("labelId","1002");*/
        map.put("page",page+"");
        map.put("count",count+"");
        listPersenter.getList(map);
    }

    @Override
    public void Success(List<ListBean> list) {
       // Toast.makeText(getActivity(),"list请求成功",Toast.LENGTH_SHORT).show();
        if (list!=null){
            listBeans = list;
            if (page==1){
                xrc.setLayoutManager(new GridLayoutManager(getActivity(),2));
                listAdapter = new ListAdapter(getActivity(),list);
                xrc.setAdapter(listAdapter);
                xrc.refreshComplete();
            }else {

               /* xrc.setLayoutManager(new GridLayoutManager(getActivity(),2));
                ListAdapter listAdapter = new ListAdapter(getActivity(),list);
                xrc.setAdapter(listAdapter);*/
                listAdapter.addlist(listBeans);
                xrc.refreshComplete();
            }

        }


    }

    @Override
    public void Fail(String msg) {
        Toast.makeText(getActivity(),"list请求失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SuccessXq(List<XqBean> xqBeans) {
        Toast.makeText(getActivity(),"xq请求成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void FailXq(String msg) {
        Toast.makeText(getActivity(),"xq请求失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        page=1;
        initData();
    }

    @Override
    public void onLoadMore() {
        page++;
        initData();
    }
}
