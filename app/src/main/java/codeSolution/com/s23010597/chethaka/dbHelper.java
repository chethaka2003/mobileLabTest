package codeSolution.com.s23010597.chethaka;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "labtest";
    public static final String TABLE_NAME = "users";
    public static final String COL_1 = "user_name";
    public static final String COL_2 = "PASSWORD";


    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME +" (user_name VARCHAR(30) PRIMARY KEY AUTOINCREMENT,"
        + "user_password VARCHAR(30))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);

    }
}
