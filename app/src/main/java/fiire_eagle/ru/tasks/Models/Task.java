package fiire_eagle.ru.tasks.Models;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

import com.orm.SugarApp;
import com.orm.SugarRecord;
import com.orm.query.Select;

import fiire_eagle.ru.tasks.R;
import fiire_eagle.ru.tasks.TasksApp;

/**
 * Created by FireEagle on 19.03.2016.
 */

public class Task extends SugarRecord{
    private Long id;
    String title;
    String date;
    String description;

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

    public LinearLayout getView(LayoutInflater inflater) {
        LinearLayout container = (LinearLayout)inflater.inflate(R.layout.task, null, false);
        ViewGroup.LayoutParams container_params = container.getLayoutParams();
        TextView title = (TextView) container.findViewById(R.id.task_title);
        title.setText(getTitle());
        TextView date = (TextView) container.findViewById(R.id.task_date);
        date.setText(getDate());
        TextView description = (TextView) container.findViewById(R.id.task_description);
        description.setText(getDescription());

        return container;
    }

    public static List<Task> getTasks() {
        return Select.from(Task.class).list();
    }
}
