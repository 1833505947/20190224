package com.example.jinjiezhouermn_20190223.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jinjiezhouermn_20190223.R;
import com.example.jinjiezhouermn_20190223.XqActivity;
import com.example.jinjiezhouermn_20190223.entity.ListBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class ListAdapter extends XRecyclerView.Adapter<ListAdapter.ViewHolder> {
    private Context context;
    private List<ListBean> list;

    public ListAdapter(Context context, List<ListBean> list) {
        this.context = context;
        this.list = list;
    }
public void addlist(List<ListBean> list){
        this.list.addAll(list);
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ListBean listBean = list.get(i);
        viewHolder.name.setText(listBean.commodityName);
        viewHolder.price.setText(listBean.price+"");
        viewHolder.simple.setImageURI(listBean.masterPic);
        viewHolder.num.setText("已售"+listBean.saleNum+"件");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, XqActivity.class);
                intent.putExtra("id",listBean.commodityId+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView simple;
        TextView name,price,num;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.simple);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            num = itemView.findViewById(R.id.num);

        }
    }
}
