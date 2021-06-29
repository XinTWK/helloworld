package com.larva.helloworld.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.larva.helloworld.R;

/**
 * created by Xin on 2021/06/23.
 */

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;


//    private List<String> list;

    public StaggeredGridAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }


    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_grid_recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(StaggeredGridAdapter.LinearViewHolder holder, int position) {
        if (position % 2 != 0) {
            holder.imageView.setImageResource(R.drawable.image1);
        } else {
            holder.imageView.setImageResource(R.drawable.image2);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }

}
