package ir.cdesign.planner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import ir.cdesign.planner.model.Tasks;

/**
 * Created by amin pc on 13/09/2016.
 */
public class DataBase extends SQLiteOpenHelper{

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Task";

    private static final String TABLE_HISTORY_TASKS = "historyTasks";
    private static final String TABLE_FUTURE_TASKS = "futureTasks";

    // Contacts Table Columns names
    private static final String KEY_ID = "_id";
    private static final String TITLE = "title";
    private static final String BODY = "body";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HISTORY_TABLE = "CREATE TABLE " + TABLE_HISTORY_TASKS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + TITLE + " TEXT,"
                + BODY + " TEXT" + ")";

        String CREATE_FUTURE_TABLE = "CREATE TABLE " + TABLE_FUTURE_TASKS + "(" + KEY_ID +
                " INTEGER PRIMARY KEY, " + TITLE + " TEXT," + BODY + " TEXT " + ")";

        db.execSQL(CREATE_HISTORY_TABLE);
        db.execSQL(CREATE_FUTURE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY_TASKS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FUTURE_TASKS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    public void addTaskHistory(Tasks task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE, task.getTitle()); // Contact Name
        values.put(BODY, task.getBody()); // Contact Phone

        // Inserting Row
        db.insert(TABLE_HISTORY_TASKS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Tasks getTaskHistory(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_HISTORY_TASKS, new String[] { KEY_ID,
                        TITLE, BODY }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Tasks task = new Tasks(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return task;
    }

    // Getting All Contacts
    public List<Tasks> getAllTasksHistory() {
        List<Tasks> contactList = new ArrayList<Tasks>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_HISTORY_TASKS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Tasks task = new Tasks();
//                task.setID(Integer.parseInt(cursor.getString(0)));
                task.setTitle(cursor.getString(1));
//                task.setPhoneNumber(cursor.getString(2));
                // Adding contact to list
                contactList.add(task);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // Updating single contact
    public int updateTaskHistory(Tasks task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE, task.getTitle());
        values.put(BODY, task.getBody());

        // updating row
        return db.update(TABLE_HISTORY_TASKS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(task.getID()) });
    }

    // Deleting single contact
    public void deleteTaskHistory(Tasks task) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_HISTORY_TASKS, KEY_ID + " = ?",
                new String[] { String.valueOf(task.getID()) });
        db.close();
    }


    // Getting contacts Count
    public int getHistoryCount() {
        String countQuery = "SELECT  * FROM " + TABLE_HISTORY_TASKS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
