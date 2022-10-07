package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlayersAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Player> playerList;

    public PlayersAdapter(Context context, int layout, List<Player> courses) {
        this.context = context;
        this.layout = layout;
        this.playerList = courses;
    }



    @Override
    public int getCount() {
        return playerList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        ImageView img ;
        TextView txtName;
        TextView txtDescription;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            // Ánh xạ View
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.txtDescription  = (TextView) convertView.findViewById(R.id.description);
            holder.img = (ImageView) convertView.findViewById(R.id.img);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Gán giá trị
        Player course = playerList.get(position);

        holder.txtName.setText(course.getName());
        holder.txtDescription.setText(course.getDescription());
        holder.img.setImageResource(course.getImage());

        return convertView;
    }
}
