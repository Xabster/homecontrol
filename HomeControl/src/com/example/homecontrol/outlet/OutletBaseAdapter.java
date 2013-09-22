package com.example.homecontrol.outlet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
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
public class OutletBaseAdapter extends BaseAdapter {

    ArrayList<OutletData> mList = new ArrayList<OutletData>();
    LayoutInflater inflater;
    Context context;

    public OutletBaseAdapter(Context context, ArrayList<OutletData> myList) {
        mList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context); // only context can also be used
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public OutletData getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        OutletData myOutletData = mList.get(position);

        if (myOutletData.getType() == 0) {
            MyViewHolder myViewHolder;

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.outlet_list_item, null);
                myViewHolder = new MyViewHolder();
                convertView.setTag(myViewHolder);
            } else {
                myViewHolder = (MyViewHolder) convertView.getTag();
            }

            final int myOutletAddress = mList.get(position).getAddress();
            myViewHolder.OutletName = (TextView) convertView.findViewById(R.id.OutletName);
            myViewHolder.OutletName.setText(mList.get(position).getName());
            myViewHolder.OutletName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    new OutletCommand(myOutletAddress, "OFF");
                }
            });

            myViewHolder.OutletButtonOn = (Button) convertView.findViewById(R.id.OutletButtonOn);
            myViewHolder.OutletButtonOn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    new OutletCommand(myOutletAddress, "ON");
                }
            });

            myViewHolder.OutletButtonOff = (Button) convertView.findViewById(R.id.OutletButtonOff);
            myViewHolder.OutletButtonOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    new OutletCommand(myOutletAddress, "OFF");
                }
            });

            return convertView;
        }
        else
        {
            ListItem_Value_Holder myViewHolder;

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.listitem_value, null);
                myViewHolder = new ListItem_Value_Holder();
                convertView.setTag(myViewHolder);
            } else {
                myViewHolder = (ListItem_Value_Holder) convertView.getTag();
            }

            myViewHolder.Name = (TextView) convertView.findViewById(R.id.ListItem_Value_Name);
            myViewHolder.Name.setText(mList.get(position).getName());

            myViewHolder.Value = (EditText) convertView.findViewById(R.id.ListItem_Value_Value);
            myViewHolder.Value.setText("10");

            return convertView;
        }
    }

    private class MyViewHolder {
        TextView OutletName;

        Button OutletButtonOn;
        Button OutletButtonOff;
    }

    private class ListItem_Value_Holder {
        TextView Name;

        EditText Value;
    }
}
