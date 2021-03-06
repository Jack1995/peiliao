package com.wenmingkeji.peiliao.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.wenmingkeji.peiliao.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 10564 on 2016/7/12.
 */
public class AlreadyGroundingFragment extends Fragment {

    private ListView lv_grounding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpager_already_grounding,null);
        lv_grounding = (ListView) view.findViewById(R.id.lv_grounding);
        initData();

        return view;
    }

    private void initData() {
        List<String> serviceName = new ArrayList<String>();
        serviceName.add("我能*陪聊天");
        serviceName.add("我能*陪唱歌");
        serviceName.add("我能*陪LOL");
        serviceName.add("我能*陪逛街");
        serviceName.add("我能*取快递");
        List<String> howMuch = new ArrayList<String>();
        howMuch.add("5元");
        howMuch.add("5元");
        howMuch.add("5元");
        howMuch.add("5元");
        howMuch.add("5元");
        List<Integer> sellCount = new ArrayList<Integer>();
        sellCount.add(5);
        sellCount.add(5);
        sellCount.add(5);
        sellCount.add(5);
        sellCount.add(5);
        List<Integer> visitorCount = new ArrayList<Integer>();
        visitorCount.add(5);
        visitorCount.add(5);
        visitorCount.add(5);
        visitorCount.add(5);
        visitorCount.add(5);
        List<Integer> inventory = new ArrayList<Integer>();
        inventory.add(5);
        inventory.add(5);
        inventory.add(5);
        inventory.add(5);
        inventory.add(5);
        lv_grounding.setAdapter(new MyAdapter(getContext(),serviceName,howMuch,sellCount,visitorCount,inventory));
    }

    private class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        List<String> mServiceName;
        List<String> mHowMuch;
        List<Integer> mSellCount;
        List<Integer> mVisitorCount;
        List<Integer> mInventory;
        private MyAdapter(Context context,List<String> serviceName,
                          List<String> howMuch, List<Integer> sellCount, List<Integer> visitorCount, List<Integer> inventory){
            this.mServiceName = serviceName;
            this.mHowMuch = howMuch;
            this.mSellCount = sellCount;
            this.mVisitorCount = visitorCount;
            this.mInventory = inventory;
            mInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return mServiceName.size();
        }

        @Override
        public Object getItem(int i) {
            return mServiceName.size();
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ViewHolderAdapter holder = null;
            if (view==null){
                holder = new ViewHolderAdapter();
                view = mInflater.inflate(R.layout.list_ground_goods,null);
                holder.serviceName = (TextView) view.findViewById(R.id.iv_serviceName);
                holder.howMuch = (TextView) view.findViewById(R.id.tv_howMuch);
                holder.sellCount = (TextView) view.findViewById(R.id.sellCount);
                holder.visitorCount = (TextView) view.findViewById(R.id.visitorCount);
                holder.inventory = (TextView) view.findViewById(R.id.inventory);
                holder.delete = (TextView) view.findViewById(R.id.delete);
                view.setTag(holder);
        }else{
                holder = (ViewHolderAdapter) view.getTag();
            }
            holder.serviceName.setText(mServiceName.get(i));
            holder.howMuch.setText(mHowMuch.get(i));
            holder.sellCount.setText(mSellCount.get(i).toString());
            holder.visitorCount.setText(mVisitorCount.get(i).toString());
            holder.inventory.setText(mInventory.get(i).toString());
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(getContext()).setTitle("提示").setMessage("是否删除选中的服务？")
                            .setPositiveButton("是", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    mServiceName.remove(i);
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("否", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();
                }
            });
            return view;
        }
    }
    public final class ViewHolderAdapter{
        public TextView serviceName;
        public TextView howMuch;
        public TextView sellCount;
        public TextView visitorCount;
        public TextView inventory;
        public TextView delete;
    }
}
