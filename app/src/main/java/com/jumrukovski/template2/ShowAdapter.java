package com.jumrukovski.template2;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jumrukovski.template2.base.BaseBindingAdapter;
import com.jumrukovski.template2.base.BaseBindingViewHolder;
import com.jumrukovski.template2.data.model.Item;
import com.jumrukovski.template2.databinding.ItemShowBinding;

import javax.inject.Inject;


public class ShowAdapter extends BaseBindingAdapter<Item> {

    private final Context context;

    @Inject
    ShowAdapter(Context context) {
        this.context = context;
    }

    @Override
    protected ViewDataBinding bind(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return ItemShowBinding.inflate(inflater, parent, false);
    }

    @Override
    public void onBindViewHolder(BaseBindingViewHolder holder, int position) {
        Item item = items.get(position);

        ItemShowBinding binding = (ItemShowBinding) holder.binding;
        binding.title.setText(item.getOriginalName());
        binding.description.setText(item.getOverview());

        GlideApp.with(context)
                .load("http://image.tmdb.org/t/p/w150" + item.getPosterPath())
                .into(binding.thumb);
    }
}
