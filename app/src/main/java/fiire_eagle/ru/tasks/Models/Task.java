package fiire_eagle.ru.tasks.Models;

import android.app.Application;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import fiire_eagle.ru.tasks.TasksApp;

/**
 * Created by FireEagle on 19.03.2016.
 */
public class Task {
    private String title;
    private String date;
    private String description;

    Task(String title, String date, String description) {
        this.title = description;
        this.date = date;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return title + " " + date + " " + description;
    }

    public View getView() {
        LinearLayout container = new LinearLayout(TasksApp.getAppContext());
        container.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        container.setLayoutParams(params);
        TextView title = new TextView(TasksApp.getAppContext());
        title.setText(getTitle());
        TextView date = new TextView(TasksApp.getAppContext());
        date.setText(getDate());
        container.addView(title);
        container.addView(date);
        return container;
    }
}
