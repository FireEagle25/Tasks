package fiire_eagle.ru.tasks.activites;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import fiire_eagle.ru.tasks.Models.Task;
import fiire_eagle.ru.tasks.R;

public class TaskDetaily extends AppCompatActivity {
    Task task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detaily);

        Intent intent = getIntent();
        String id = intent.getStringExtra("task_id");

        task = Task.findById(Task.class, Integer.parseInt(id));
        showData();

        Switch isDone = (Switch) findViewById(R.id.isDone);
        isDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    task.delete();
                    new Handler() {{
                        postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, 500);
                    }};
                }
            }
        });
    }

    protected void showData() {
        TextView titleTextView = (TextView)findViewById(R.id.task_title);
        TextView dateTextView = (TextView)findViewById(R.id.task_date);
        TextView descriptionTextView = (TextView)findViewById(R.id.task_description);

        titleTextView.setText(task.getTitle());
        dateTextView.setText(task.getDate());
        descriptionTextView.setText(task.getDescription());
    }

}
