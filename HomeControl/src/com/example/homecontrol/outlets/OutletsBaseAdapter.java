package com.example.homecontrol.outlets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.homecontrol.R;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Lennon
 * Date: 19-09-13
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
public class OutletsBaseAdapter extends BaseAdapter {

    ArrayList<OutletsData> mList = new ArrayList<OutletsData>();
    LayoutInflater inflater;
    Context context;

    public OutletsBaseAdapter(Context context, ArrayList<OutletsData> myList) {
        mList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context); // only context can also be used


    }


    @Override
    public int getCount() {
        return mList.size();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public OutletsData getItem(int position) {
        return mList.get(position);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getItemId(int position) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.outlet_list_item, null);
            myViewHolder = new MyViewHolder();
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        myViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.outlet_title);
        myViewHolder.tvTitle.setText(mList.get(position).getName());

        //myViewHolder.tvDesc = (TextView) convertView.findViewById(R.id.outlet_text);
        //myViewHolder.tvDesc.setText(mList.get(position).getAddress());

        return convertView;  //To change body of implemented methods use File | Settings | File Templates.


    }

    private class MyViewHolder {
        TextView tvTitle, tvDesc;
    }
}
