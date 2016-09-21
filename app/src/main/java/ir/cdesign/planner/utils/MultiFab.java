package ir.cdesign.planner.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.FrameLayout;

import ir.cdesign.planner.ChooseCategory;
import ir.cdesign.planner.R;

/**
 * Created by amin pc on 27/08/2016.
 */
public class MultiFab {

    View view;
    FrameLayout frameLayout;
    public Activity activity;
    FloatingActionButton mainFab, firstFab, secondFab, thirdFab;
    Context context;

    public static String Tag ;

    public MultiFab(Activity activity , Context context){
        this.activity = activity;
        this.context = context;

        mainFab = (FloatingActionButton) this.activity.findViewById(R.id.fab_main);
        firstFab = (FloatingActionButton) this.activity.findViewById(R.id.fab_child_one);
        secondFab = (FloatingActionButton) this.activity.findViewById(R.id.fab_child_two);

        firstFab.hide();
        secondFab.hide();

        firstFab.setAlpha(0f);
        secondFab.setAlpha(0f);
    }

    public void setFab(){
        mainFab = (FloatingActionButton) this.activity.findViewById(R.id.fab_main);
        mainFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstFab.isShown()){
                    invisible();
                } else visible();
            }
        });

        firstFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ChooseCategory.class);
                Tag = "FUTURE";
                intent.putExtra("tag",Tag);
                activity.startActivity(intent);
            }
        });
        secondFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ChooseCategory.class);
                Tag = "HISTORY";
                intent.putExtra("tag",Tag);
                activity.startActivity(intent);
            }
        });

    }

    public void visible() {
        FloatingActionButton fab;

        mainFab.animate().rotationBy(45).start();

        try {
            frameLayout = (FrameLayout) this.activity.findViewById(R.id.fab_parent);
            frameLayout.setVisibility(View.VISIBLE);
            frameLayout.setBackgroundColor(this.activity.getResources().getColor(R.color.colorBackgroundActive));
            frameLayout.animate().alpha(.7f).start();
            frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    invisible();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

        int[] children = new int[]{
                R.id.fab_child_one , R.id.fab_child_two};

        try {
            for (int i = 0 ; i < 3 ; i++){
                fab = (FloatingActionButton) this.activity.findViewById(children[i]);
                fab.show();
                fab.animate().alpha(1).start();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void invisible() {
        FloatingActionButton fab;

        mainFab.animate().rotationBy(-45).start();

        try {
            frameLayout = (FrameLayout) this.activity.findViewById(R.id.fab_parent);
            frameLayout.setBackgroundColor(this.activity.getResources().getColor(R.color.colorBackgroundDeActive));
            frameLayout.setAlpha(0f);
            frameLayout.setVisibility(View.GONE);
        }catch (Exception e ){
            e.printStackTrace();
        }

        int[] children = new int[]{
                R.id.fab_child_one , R.id.fab_child_two };

        try {
            for (int i = 0 ; i < 3 ; i++){
                fab = (FloatingActionButton) this.activity.findViewById(children[i]);
                fab.hide();
                fab.animate().alpha(0).start();

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
