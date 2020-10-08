package com.example.ghagenie.ui.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ghagenie.ui.model.NoteItem;

import java.util.ArrayList;
import java.util.List;

public abstract class GenieBaseAdapter<T> extends RecyclerView.Adapter<GenieBaseAdapter.ViewHolder> {

    protected List<T> mItems = new ArrayList<>();
    protected IRecyclerEventCallback iRecyclerEventCallback;

    public GenieBaseAdapter(IRecyclerEventCallback callback, List<T> items) {
        iRecyclerEventCallback = callback;
        mItems = items;
    }

    public void addItems(List<T> items){
        int startPosition = mItems.size();
        mItems.addAll(items);
        notifyItemRangeInserted(startPosition,items.size());
    }

    public void addItem(T item){
        int positionToInsert = mItems.size();
        mItems.add(item);
        notifyItemInserted(positionToInsert);
    }

    @NonNull
    @Override
    public GenieBaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                getViewHolderResourceId(), parent, false);
        return getViewHolder(view);
    }

    public abstract int getViewHolderResourceId();

    public abstract ViewHolder getViewHolder(View view);

    @Override
    public abstract void onBindViewHolder(@NonNull GenieBaseAdapter.ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
