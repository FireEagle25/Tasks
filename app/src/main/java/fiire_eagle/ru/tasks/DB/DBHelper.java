package fiire_eagle.ru.tasks.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by FireEagle on 19.03.2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "TasksInfo";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tasks ("
                + "id integer primary key autoincrement,"
                + "title text,"
                + "date text,"
                + "description text"
                + ");");
        Log.v("DB", "DB create");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        return;
    }

    public long insert(String table,ContentValues cv){
        long result=-1;
        try {
            result = this.getWritableDatabase().insert(table, null, cv);
        }catch (Exception e) {
            Log.v("DB", e.getMessage());
        }
        finally{
            this.getWritableDatabase().close();
        }
        return result;
    }

    public Cursor select(String tableName, String[] columns, String orderByColumnName){
        Cursor query_result = this.getWritableDatabase().query(tableName, columns, null, null, null, null, null, null);
        return query_result;
    }
}