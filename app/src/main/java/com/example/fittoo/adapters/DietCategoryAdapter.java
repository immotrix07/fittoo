package com.example.fittoo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fittoo.R;
import com.example.fittoo.models.DietCategory;
import java.util.List;

public class DietCategoryAdapter extends RecyclerView.Adapter<DietCategoryAdapter.ViewHolder> {

    private final List<DietCategory> categories;
    private final CategoryClickListener clickListener;

    public DietCategoryAdapter(List<DietCategory> categories, CategoryClickListener clickListener) {
        this.categories = categories;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_diet_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DietCategory category = categories.get(position);
        holder.ivCategory.setImageResource(category.getImageResId());
        holder.tvCategoryName.setText(category.getName());
        
        holder.itemView.setOnClickListener(v -> 
            clickListener.onCategoryClick(category)
        );
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCategory;
        TextView tvCategoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCategory = itemView.findViewById(R.id.iv_category);
            tvCategoryName = itemView.findViewById(R.id.tv_category_name);
        }
    }

    public interface CategoryClickListener {
        void onCategoryClick(DietCategory category);
    }
}