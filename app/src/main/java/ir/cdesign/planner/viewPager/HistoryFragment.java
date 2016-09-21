package ir.cdesign.planner.viewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ir.cdesign.planner.DataBase;
import ir.cdesign.planner.R;
import ir.cdesign.planner.model.Tasks;

/**
 * Created by amin pc on 14/09/2016.
 */
public class HistoryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history_layout,container,false);

        setList(view);

        return view;
    }

    private void setList(View view){
        ListView listView = (ListView) view.findViewById(R.id.list);

        DataBase db = new DataBase(getActivity());
        List<Tasks> tasks = db.getAllTasksHistory();
        ArrayList<String> list = new ArrayList<String>();
        for (Tasks cn : tasks) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getTitle() + " ,Phone: " + cn.getBody();
            String a = String.valueOf(cn.getTitle());
            list.add(a);
        }
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1,list);
        listView.setAdapter(adapter);
    }

}
