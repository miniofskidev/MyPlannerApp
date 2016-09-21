package ir.cdesign.planner;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import ir.cdesign.planner.adapters.CategoryAdapter;
import ir.cdesign.planner.model.categories;
import ir.cdesign.planner.utils.MultiFab;

public class ChooseCategory extends AppCompatActivity {

    RecyclerView recyclerView;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
        setRecycler();
        catchExtra();
    }


    private void setRecycler(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        categories categories = new categories();
        GridLayoutManager glm = new GridLayoutManager(this,4);
        CategoryAdapter adapter = new CategoryAdapter(this, categories.getData());
        recyclerView.setLayoutManager(glm);
        recyclerView.setAdapter(adapter);
    }

    private void catchExtra() {

        Intent intent = getIntent();
        String judge = intent.getStringExtra("tag");

        if (judge.equals("FUTURE")){
            Toast.makeText(ChooseCategory.this, judge, Toast.LENGTH_SHORT).show();
        } else if (judge.equals("HISTORY")){
            Toast.makeText(ChooseCategory.this, judge, Toast.LENGTH_SHORT).show();
        }

    }
}
