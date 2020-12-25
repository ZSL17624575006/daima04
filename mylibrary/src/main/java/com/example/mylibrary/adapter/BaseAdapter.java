package com.example.mylibrary.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylibrary.R;

import java.util.List;

public abstract class BaseAdapter<D> extends RecyclerView.Adapter {
    List<D> mdata;
    Context context;
    private final LayoutInflater inflater;
    private IListClick click;

    public BaseAdapter(Context context,List<D> mdata){
        this.context = context;
        this.mdata = mdata;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(getItemCount(),parent,false);
        HomeViewHodel homeViewHodel = new HomeViewHodel(view);
        homeViewHodel.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click!=null){
                    click.itemClick(homeViewHodel.getLayoutPosition());
                }
            }
        });
        return homeViewHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            bindData(mdata.get(position), (HomeViewHodel) holder);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }
    protected abstract int getLayout();
    protected abstract void bindData(D data,HomeViewHodel homeViewHodel);
    public void addListClick(IListClick click){
        this.click = click;
    }
    public interface IListClick{
        void itemClick(int pos);
    }


    public class HomeViewHodel extends RecyclerView.ViewHolder {
        SparseArray views = new SparseArray();
        public HomeViewHodel(@NonNull View itemView) {
            super(itemView);
        }
        public View getViewId(int id){
            View view = (View) views.get(id);
            if (view==null){
                view=itemView.findViewById(id);
                views.append(id,view);
            }
            return view;
        }
    }
}
