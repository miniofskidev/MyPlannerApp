package ir.cdesign.planner;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.cdesign.planner.adapters.CategoryAdapter;
import ir.cdesign.planner.model.Tasks;
import ir.cdesign.planner.model.categories;
import ir.cdesign.planner.persianmaterialdatetimepicker.date.DatePickerDialog;
import ir.cdesign.planner.persianmaterialdatetimepicker.utils.PersianCalendar;
import ir.cdesign.planner.persianmaterialdatetimepicker.utils.PersianDateParser;
import ir.cdesign.planner.utils.CalendarTool;
import ir.cdesign.planner.utils.CategoryDialog;
import ir.cdesign.planner.utils.MultiFab;
import ir.cdesign.planner.viewPager.HostFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CalendarTool calendar;
    String date;
    TextView dateText, categoryTv;
    EditText TitleEditText, BodyEditText;
    Button SubmitButton;
    RecyclerView recyclerView;
    FloatingActionButton fab;

    String tTitle, tBody;

    DataBase dataBase = new DataBase(this);

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    public static MainActivity mainActivity;

    private long timestamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = this ;

        init();


        MultiFab multiFab = new MultiFab(this, this);
        multiFab.setFab();
    }


    private void init() {

        calendar = new CalendarTool();
        date = calendar.getIranianDate();
        dateText = (TextView) findViewById(R.id.calendar);
//        dateText.setText(date);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.container, new HostFragment()).commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            /*case R.id.calendar: {
                PersianCalendar now = new PersianCalendar();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        MainActivity.this,
                        now.getPersianYear(),
                        now.getPersianMonth(),
                        now.getPersianDay()
                );
                dpd.show(getFragmentManager(), "DATE PICKER");
                break;
            }
            case R.id.submit: {
                DataBase db = new DataBase(this);

                tTitle = String.valueOf(TitleEditText.getText());
                tBody = String.valueOf(BodyEditText.getText());


                // Reading all contacts
                Log.d("Reading: ", "Reading all contacts..");

                for (Tasks cn : tasks) {
                    String log = "Id: " + cn.getID() + " ,Name: " + cn.getTitle() + " ,Phone: " + cn.getBody();
                    // Writing Contacts to log
                    Log.d("Name: ", log);
                }
                startActivity(new Intent(MainActivity.this,TaskShow.class));
                break;
            }
            case R.id.category_tv:{
                CategoryDialog categoryDialog = new CategoryDialog();
                categoryDialog.show(getSupportFragmentManager(),"CategoryDialog");
            }*/
        }
    }

}
