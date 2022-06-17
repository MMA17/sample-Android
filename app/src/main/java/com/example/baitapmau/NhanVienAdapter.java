package com.example.baitapmau;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class NhanVienAdapter extends BaseAdapter {
    private List<NhanVien> listNV;
    private Context context;

    private class viewHolder {
        TextView nvTen;
        TextView nvDOB;
        TextView nvQueQuan;
        TextView nvTrinhDo;
    }

    public NhanVienAdapter(List<NhanVien> listNV, Context context) {
        this.listNV = listNV;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listNV.size();
    }

    @Override
    public Object getItem(int i) {
        return listNV.get(i);
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
            view = li.inflate(R.layout.nhanvien_item, null);
            vh.nvTen = view.findViewById(R.id.nvTen);
            vh.nvDOB = view.findViewById(R.id.nvDOB);
            vh.nvQueQuan = view.findViewById(R.id.nvQueQuan);
            vh.nvTrinhDo = view.findViewById(R.id.nvTrinhDo);
            view.setTag(vh);
        }
        else {
            vh = (viewHolder) view.getTag();
        }

        vh.nvTen.setText(listNV.get(i).getTen());
        vh.nvDOB.setText(listNV.get(i).getDob());
        vh.nvTrinhDo.setText(listNV.get(i).getTrinhdo());
        vh.nvQueQuan.setText(listNV.get(i).getQueQuan());
        return view;
    }
}
