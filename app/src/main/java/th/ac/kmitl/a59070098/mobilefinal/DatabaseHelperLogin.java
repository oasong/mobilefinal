package th.ac.kmitl.a59070098.mobilefinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelperLogin extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "contacts";
    private static final String COL_COUNT = "id";
    private static final String COL_ID = "id_name";
    private static final String COL_NAME = "name";
    private static final String COL_AGE = "age";
    private static final String COL_PASSWORD = "password";
    private static final String COL_TEXT = "text";

    public DatabaseHelperLogin(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY, " +
                COL_ID + " TEXT NOT NULL," + COL_NAME + " TEXT NOT NULL, " + COL_AGE + " INT, " + COL_PASSWORD + " TEXT NOT NULL, " + COL_TEXT + "TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertContact(Contact c){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        contentValues.put(COL_COUNT, count);
        contentValues.put(COL_ID, c.getId());
        contentValues.put(COL_NAME, c.getName());
        contentValues.put(COL_AGE, c.getAge());
        contentValues.put(COL_PASSWORD, c.getPassword());
        contentValues.put(COL_TEXT, c.getMyText());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public String searchPassword(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COL_ID + ", " + COL_PASSWORD + " FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        String username, userpassword = "";
//        Log.d("Check value", "password = " + cursor.getString(1));
        if (cursor.moveToFirst()){
            do{
                username = cursor.getString(0);
                if (username.equals(name)){
                    userpassword = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return userpassword;
    }

    public Cursor getItemName(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL_NAME + " FROM " + TABLE_NAME +
                " WHERE " + COL_ID + " = '" + id + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItemAge(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL_AGE + " FROM " + TABLE_NAME +
                " WHERE " + COL_ID + " = '" + id + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItemText(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL_TEXT + " FROM " + TABLE_NAME +
                " WHERE " + COL_ID + " = '" + id + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }


}
