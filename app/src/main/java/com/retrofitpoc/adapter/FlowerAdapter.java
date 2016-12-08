package com.retrofitpoc.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.retrofitpoc.R;
import com.retrofitpoc.model.FlowerModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by aalishan on 22/11/16.
 */

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.ViewHolder> {
    private List<FlowerModel> dto;
    private Context ctx;
    private LayoutInflater inflater;

    public FlowerAdapter(Context ctx, List<FlowerModel> dto) {
        this.dto = dto;
        this.ctx = ctx;
        inflater = LayoutInflater.from(ctx);


    }

    @Override
    public FlowerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_item_flowers, parent, false);
        FlowerAdapter.ViewHolder holder = new FlowerAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FlowerAdapter.ViewHolder holder, int position) {
        holder.mTvName.setText(dto.get(position).getName());
        holder.mTvPrice.setText(String.valueOf(dto.get(position).getPrice()));
        holder.mTvCategory.setText(dto.get(position).getCategory());
        holder.mTvInstructions.setText(dto.get(position).getInstructions());
        String url = "http://service.hanselandpetal.com/photos/" + dto.get(position).getPhoto();
      //  String url = "https://api.learn2crack.com/android/images/kitkat.png";

        Glide.with(ctx).load(url).into(holder.mIvImage);

    }

    @Override
    public int getItemCount() {
        return dto.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvName;
        ImageView mIvImage;
        TextView mTvPrice;
        TextView mTvCategory;
        TextView mTvInstructions;
        CardView mCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvName = (TextView) itemView.findViewById(R.id.tv_name_value);
            mTvPrice = (TextView) itemView.findViewById(R.id.tv_price_value);
            mTvCategory = (TextView) itemView.findViewById(R.id.tv_category_value);
            mTvInstructions = (TextView) itemView.findViewById(R.id.tv_instruction);
            mCardView = (CardView) itemView.findViewById(R.id.card_view);
            mIvImage = (ImageView) itemView.findViewById(R.id.iv_title);
        }


    }
}
