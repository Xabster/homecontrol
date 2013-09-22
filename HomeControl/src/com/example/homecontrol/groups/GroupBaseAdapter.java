package com.example.homecontrol.groups;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.homecontrol.GroupListView_Activity;
import com.example.homecontrol.OutletsListView_Activity;
import com.example.homecontrol.R;
import com.example.homecontrol.outlet.OutletCommand;

import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA.
 * User: Lennon
 * Date: 19-09-13
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
public class GroupBaseAdapter extends BaseAdapter {

    ArrayList<GroupData> mList = new ArrayList<GroupData>();
    LayoutInflater inflater;
    Context context;

    public GroupBaseAdapter(Context context, ArrayList<GroupData> myList) {
        mList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context); // only context can also be used
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public GroupData getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        GroupData myOutletData = mList.get(position);

        MyViewHolder myViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.group_list_item, null);
            myViewHolder = new MyViewHolder();
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }


        myViewHolder.Name = (TextView) convertView.findViewById(R.id.Group_Name);
        myViewHolder.Name.setText(mList.get(position).getName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OutletsListView_Activity.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    private class MyViewHolder {
        TextView Name;
    }
}
