package fiire_eagle.ru.tasks.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import java.util.List;

import fiire_eagle.ru.tasks.R;
import fiire_eagle.ru.tasks.Models.*;

public class AllTasks extends AppCompatActivity {
    protected ScrollView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        content = (ScrollView) findViewById(R.id.all_tasks_content);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewTaskActivity();
            }
        });

        for(int i = 0; i < 10; i++) {
            try {
                Task newTask = new Task("1", "2", "3");
                newTask.save();
            }
            catch (Exception e) {
                Log.e("DB", e.getMessage());
            }
        }


        try {
            List<Task> allTasks = Task.getTasks();
            for(int i = 0; i < allTasks.size(); i++)
                content.addView(allTasks.get(i).getView());
        }
        catch (Exception e){
            Log.e("DB", e.getMessage());
        }
    }

    protected void showNewTaskActivity() {
        Intent intent = new Intent(this, NewTask.class);
        startActivity(intent);
    }
}
