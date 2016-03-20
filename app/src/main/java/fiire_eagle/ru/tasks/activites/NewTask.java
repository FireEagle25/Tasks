package fiire_eagle.ru.tasks.activites;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import fiire_eagle.ru.tasks.Models.Task;
import fiire_eagle.ru.tasks.R;

public class NewTask extends AppCompatActivity {
    EditText title;
    EditText date;
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title = (EditText) findViewById(R.id.title);
        //date = (EditText) findViewById(R.id.date);
        description = (EditText) findViewById(R.id.description);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task newTask = new Task(title.getText().toString(), date.getText().toString(), description.getText().toString());
                newTask.save();

                Log.d("DB", String.valueOf(R.string.success_message));

                Snackbar.make(view, String.valueOf(R.string.success_message), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                finish();
            }
        });
    }

}
