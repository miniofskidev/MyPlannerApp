package ir.cdesign.planner.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.cdesign.planner.R;
import ir.cdesign.planner.adapters.CategoryAdapter;
import ir.cdesign.planner.model.categories;

/**
 * Created by amin pc on 13/09/2016.
 */
public class CategoryDialog extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_task_edit,container,false);


        return view;
    }


}
