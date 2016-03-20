package fiire_eagle.ru.tasks.Models;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

import com.orm.SugarApp;
import com.orm.SugarRecord;
import com.orm.query.Select;

import fiire_eagle.ru.tasks.TasksApp;

/**
 * Created by FireEagle on 19.03.2016.
 */

public class Task extends SugarRecord{
    private Long id;
    String title = null;
    String date = null;
    String description = null;

    public Task() {
        super();
    }

    public Task(String title, String date, String description) {
        super();
        this.title = title;
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

    public LinearLayout getView() {
        LinearLayout container = new LinearLayout(TasksApp.getAppContext());
        container.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        container.setLayoutParams(params);
        TextView title = new TextView(TasksApp.getAppContext());
        title.setText(getTitle());
        TextView date = new TextView(TasksApp.getAppContext());
        date.setText(getDate());
        TextView description = new TextView(TasksApp.getAppContext());
        date.setText(getDescription());
        container.addView(title);
        container.addView(date);
        container.addView(description);
        return container;
    }

    public static List<Task> getTasks() {
        return Select.from(Task.class).list();
    }
}
