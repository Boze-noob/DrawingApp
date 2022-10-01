package com.applid.kids.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.applid.drawing.Util.CanvasView;
import com.applid.kids.R;
import com.applid.kids.item.ColorList;
import com.applid.kids.util.Constant;

import java.util.List;


public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {

    private Activity activity;
    private CanvasView customCanvas;
    private List<ColorList> colorLists;

    public ColorAdapter(Activity activity, List<ColorList> colorLists, CanvasView customCanvas) {
        this.activity = activity;
        this.colorLists = colorLists;
        this.customCanvas = customCanvas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.color_adapter, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        try {
            holder.view.setBackgroundColor(colorLists.get(position).getColor());
        } catch (Exception e) {
            Log.d("error_color", e.toString());
        }

        holder.view.setOnClickListener(v -> {
            Constant.color_chose = colorLists.get(position).getColor();
            customCanvas.paintColor(Constant.color_chose);
        });

    }

    @Override
    public int getItemCount() {
        return colorLists.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.view_color_adapter);

        }
    }
}
