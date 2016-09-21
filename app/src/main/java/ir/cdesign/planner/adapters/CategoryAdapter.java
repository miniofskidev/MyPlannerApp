package ir.cdesign.planner.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.cdesign.planner.ChooseCategory;
import ir.cdesign.planner.R;
import ir.cdesign.planner.model.categories;
import ir.cdesign.planner.utils.CategoryDialog;

/**
 * Created by amin pc on 13/09/2016.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.holder> {

    private ArrayList<categories> categories;
    private LayoutInflater inflater;
    private Context context;

    public CategoryAdapter(Context context, ArrayList<categories> categories) {
        this.context = context;
        this.inflater = inflater.from(context);
        this.categories = categories;

    }

    @Override
    public CategoryAdapter.holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_category_row, parent, false);
        holder holder = new holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.holder holder, int position) {
        categories current = categories.get(position);
        holder.setData(current,position);

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        categories current;
        int position;

        public holder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.category_row_iv);
            textView = (TextView) itemView.findViewById(R.id.category_row_tv);
        }

        public void setData(categories current, final int position) {
            this.current = current;
            this.position = position;
            this.imageView.setImageResource(current.getImageId());
            this.textView.setText(current.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CategoryDialog categoryDialog = new CategoryDialog();
//                    categoryDialog.show(,"CategoryDialog");
                    categoryDialog.show(((ChooseCategory) context).getSupportFragmentManager(), "Title");
                    Toast.makeText(context, String.valueOf(position + 1), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
