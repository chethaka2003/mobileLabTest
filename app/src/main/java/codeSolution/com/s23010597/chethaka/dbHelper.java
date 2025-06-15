package codeSolution.com.s23010597.chethaka;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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
        db.execSQL("create table "+TABLE_NAME +" (user_name VARCHAR(30)  NOT NULL,"
        + "user_password VARCHAR(30) NOT NULL UNIQUE) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);

    }

    //Inserting data into tha db
    public boolean insertData(String name , String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues .put(COL_1,name);
        contentValues.put(COL_2,password);
        long result = db.insert(TABLE_NAME,null,new ContentValues());
        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    //Validating data
    public Cursor validateData(String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor results = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_2 + " = ?", new String[]{password});
        return results;

    }

}
