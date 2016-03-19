package fiire_eagle.ru.tasks.activites;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import fiire_eagle.ru.tasks.DB.DBHelper;
import fiire_eagle.ru.tasks.R;

public class NewTask extends AppCompatActivity {
    EditText title;
    EditText date;
    EditText description;

    protected DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title = (EditText) findViewById(R.id.title);
        date = (EditText) findViewById(R.id.date);
        description = (EditText) findViewById(R.id.description);

        dbHelper = new DBHelper(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();

                cv.put("description", description.getText().toString());
                cv.put("title", title.getText().toString());
                cv.put("date", date.getText().toString());

                Log.d("DB", String.valueOf(R.string.success_message));
                dbHelper.insert("tasks", cv);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                Snackbar.make(view, String.valueOf(R.string.success_message), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                finish();
            }
        });
    }

}
