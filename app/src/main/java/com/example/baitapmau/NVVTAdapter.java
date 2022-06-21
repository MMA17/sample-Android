package com.example.baitapmau;

import android.content.Context;
import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NVVTAdapter extends BaseAdapter {
    private Context context;
    private List<NVVTClass> listNVVT;

    private class viewHolder {
        TextView textTenNhanVien, textTenViTri;
    }

    public NVVTAdapter() {
    }

    public NVVTAdapter(Context context, List<NVVTClass> listNVVT) {
        this.context = context;
        this.listNVVT = listNVVT;
    }

    @Override
    public int getCount() {
        return listNVVT.size();
    }

    @Override
    public Object getItem(int i) {
        return listNVVT.get(i);
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
            view = li.inflate(R.layout.nhanvienvitri_item, null);
            vh.textTenNhanVien = view.findViewById(R.id.textTenNhanVien);
            vh.textTenViTri = view.findViewById(R.id.textTenViTri);
            view.setTag(vh);
        }
        else {
            vh = (viewHolder) view.getTag();
        }
        vh.textTenViTri.setText(listNVVT.get(i).getTenViTri());
        vh.textTenNhanVien.setText(listNVVT.get(i).getTenNhanVien());
        return view;
    }
}
