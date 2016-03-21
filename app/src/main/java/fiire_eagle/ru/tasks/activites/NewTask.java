package fiire_eagle.ru.tasks.activites;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import java.util.Calendar;
import fiire_eagle.ru.tasks.Models.Task;
import fiire_eagle.ru.tasks.R;

public class NewTask extends AppCompatActivity implements CalendarDatePickerDialogFragment.OnDateSetListener {
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
        date = (EditText) findViewById(R.id.date);
        description = (EditText) findViewById(R.id.description);
        date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    showDatePickerDialog();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_task);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task newTask = new Task(title.getText().toString(), date.getText().toString(), description.getText().toString());
                newTask.save();
                finish();
            }
        });

        fab.setImageResource(R.drawable.ic_exposure_plus_1);
    }

    public void showDatePickerDialog() {
        CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                .setOnDateSetListener(NewTask.this)
                .setFirstDayOfWeek(Calendar.MONDAY);
        cdp.show(getSupportFragmentManager(), "");
        description.requestFocus();
    }

    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        date.setText(Integer.toString(dayOfMonth) + "." + Integer.toString(monthOfYear) + "." + Integer.toString(year));
        description.requestFocus();
    }
}
