package fiire_eagle.ru.tasks.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import java.util.List;

import fiire_eagle.ru.tasks.R;
import fiire_eagle.ru.tasks.Models.*;

public class AllTasks extends AppCompatActivity {
    protected LinearLayout content;

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

        showAllTasks();
    }

    protected void showNewTaskActivity() {
        Intent intent = new Intent(this, NewTask.class);
        startActivity(intent);
    }

    protected void showAllTasks() {
        List<Task> allTasks = Task.getTasks();
        for(int i = 0; i < allTasks.size(); i++) {
            LinearLayout a = allTasks.get(i).getView();
            content.addView(a);
        }
    }
}
