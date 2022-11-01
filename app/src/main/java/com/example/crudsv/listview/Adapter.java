package com.example.crudsv.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.crudsv.R;
import com.example.crudsv.model.Employee;

import java.util.List;

public class Adapter extends BaseAdapter {

    public Adapter(Context context, int layout, List<Employee> employees) {
        this.context = context;
        this.layout = layout;
        this.employees = employees;
    }


    private Context context;
    private  int layout;
    private List<Employee> employees;

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtTen;
        ImageView imgdelete,imgedit;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view ==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtTen = view.findViewById(R.id.textten);
            holder.imgdelete= view.findViewById(R.id.imgdel);
            holder.imgedit = view.findViewById(R.id.imgedit);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        Employee employee = employees.get(i);
        holder.txtTen.setText(employee.getName());
        return view;
    }
}
