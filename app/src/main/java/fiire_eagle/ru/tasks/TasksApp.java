package fiire_eagle.ru.tasks;

import android.content.Context;
import com.orm.SugarApp;
import com.orm.SugarContext;

/**
 * Created by FireEagle on 19.03.2016.
 */
public class TasksApp extends SugarApp {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        TasksApp.context = getApplicationContext();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }


    public static Context getAppContext() {
        return TasksApp.context;
    }
}