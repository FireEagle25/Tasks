package fiire_eagle.ru.tasks.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import fiire_eagle.ru.tasks.R;
import fiire_eagle.ru.tasks.Models.*;

public class AllTasks extends AppCompatActivity implements View.OnClickListener {
    protected LinearLayout content;
    protected HashMap<Integer, Long> taskIdViewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        content = (LinearLayout) findViewById(R.id.all_tasks_content);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewTaskActivity();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(content.getChildCount() > 0)
            content.removeAllViews();
        showAllTasks();
    }

    protected void showNewTaskActivity() {
        Intent intent = new Intent(this, NewTask.class);
        startActivity(intent);
    }

    protected void showAllTasks() {
        List<Task> allTasks = Task.getTasks();
        int id = 0;
        taskIdViewId = new HashMap<Integer, Long>();

        if (allTasks.size() > 0) {
            id = allTasks.get(0).getView(getLayoutInflater()).getId();
            for (int i = 0; i < allTasks.size(); i++, id++) {
                taskIdViewId.put(id, allTasks.get(i).getId());
                LinearLayout currTask = allTasks.get(i).getView(getLayoutInflater());
                currTask.setId(id);
                currTask.setOnClickListener(this);
                content.addView(currTask);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, TaskDetaily.class);
        long id = taskIdViewId.get(v.getId());
        intent.putExtra("task_id", Long.toString(id));
        startActivity(intent);
    }
}
