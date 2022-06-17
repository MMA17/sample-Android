package com.example.baitapmau;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ViTriAdapter extends BaseAdapter {
    private List<ViTri> listViTri;
    private Context context;

    private class viewHolder {
        TextView textVTTen, textVTMota;
    }

    public ViTriAdapter(List<ViTri> listViTri, Context context) {
        this.listViTri = listViTri;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listViTri.size();
    }

    @Override
    public Object getItem(int i) {
        return listViTri.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder vh = new viewHolder();
        if (view == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.vitri_item, null);
            vh.textVTMota = view.findViewById(R.id.vtTen);
            vh.textVTMota = view.findViewById(R.id.vtMoTa);
            view.setTag(vh);
        }
        else {
            vh = (viewHolder) view.getTag();
        }
        vh.textVTTen.setText(listViTri.get(i).getTen());
        vh.textVTTen.setText(listViTri.get(i).getMoTa());
        return view;
    }
}
