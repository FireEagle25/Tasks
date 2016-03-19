package fiire_eagle.ru.tasks;

import android.app.Application;
import android.content.Context;

/**
 * Created by FireEagle on 19.03.2016.
 */
public class TasksApp extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        TasksApp.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return TasksApp.context;
    }
}