package com.example.ghagenie.ui.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.ghagenie.R;
import com.example.ghagenie.ui.base.GenieBaseAdapter;
import com.example.ghagenie.ui.base.IRecyclerEventCallback;
import com.example.ghagenie.ui.model.NoteItem;

import java.util.List;

public class NoteAdapter extends GenieBaseAdapter {


    public NoteAdapter(IRecyclerEventCallback callback, List<?> items) {
        super(callback, items);
    }

    @Override
    public int getViewHolderResourceId() {
        return R.layout.note_item;
    }

    @Override
    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenieBaseAdapter.ViewHolder holder, int position) {
        NoteItem item = (NoteItem) mItems.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.title.setText(item.getHeading());
    }

    public class ViewHolder extends GenieBaseAdapter.ViewHolder{

        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}
