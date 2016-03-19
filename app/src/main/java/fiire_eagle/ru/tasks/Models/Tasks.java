package fiire_eagle.ru.tasks.Models;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import fiire_eagle.ru.tasks.DB.DBHelper;
import fiire_eagle.ru.tasks.TasksApp;
import fiire_eagle.ru.tasks.activites.AllTasks;

/**
 * Created by FireEagle on 19.03.2016.
 */
public class Tasks {
    protected DBHelper dbHelper;
    public ArrayList<Task> tasks = new ArrayList<Task>();

    public Tasks() {
        dbHelper = new DBHelper(TasksApp.getAppContext());
        String[] columnsToDisplay = {"title", "date", "description"};
        Cursor cursor = null;
        try {
            cursor = dbHelper.select("tasks", columnsToDisplay, "id");
        } catch (Exception e) {
            Log.e("DB", e.getMessage());
        }

        cursor.moveToNext();
        do {
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String date = cursor.getString(cursor.getColumnIndex("date"));
            String description = cursor.getString(cursor.getColumnIndex("description"));
            Task task = new Task(title, date, description);
            tasks.add(task);
        } while (cursor.moveToNext());
        dbHelper.close();
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public int count() {
        return tasks.size();
    }

}

