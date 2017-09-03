package sqlite.mmus.com.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class MyDBFunctions extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyDB";
    private static final String TABLE_NAME = "Mytab";

    private static final String TAB_ID = "id";
    private static final String TAB_Name = "Name";
    private static final String TAB_Days = "date";


    MyDBFunctions(Context c) {
        super(c, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String s = "CREATE TABLE " + TABLE_NAME + " (" + TAB_ID + " INTEGER PRIMARY KEY  NOT NULL , " + TAB_Name + " TEXT, " + TAB_Days + " TEXT)";
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //-----------------addin data in to data base---------------------\\\\


    public void addingDataTotable(DataTemp dt) {
        SQLiteDatabase sqd = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TAB_Name, dt.getName());
        cv.put(TAB_Days, dt.getDay());
        sqd.insert(TABLE_NAME, null, cv);
        sqd.close();
    }

//---------showing data---/

    String[] my_data() {
        SQLiteDatabase sq = this.getReadableDatabase();
        String q = "SELECT * FROM " + TABLE_NAME;
        Cursor c = sq.rawQuery(q, null);
        String[] recived_data = new String[c.getCount()];
        c.moveToFirst();
        if (c.moveToFirst()) {
            int counter = 0;
            do {

                recived_data[counter] = c.getString(c.getColumnIndex(TAB_Name + "")) + "\nDOB :" + c.getString(c.getColumnIndex(TAB_Days + ""));
                counter = counter + 1;
            } while (c.moveToNext());
        }
        return recived_data;

    }

    String fetch_data(int id) {
        SQLiteDatabase sq = this.getReadableDatabase();
     //   String q = "SELECT " + TAB_Days + " FROM " + TABLE_NAME + "Where "+TAB_ID+"=" + id;
        String q="Select date FROM Mytab where id="+id;
        Cursor c = sq.rawQuery(q, null);
        String s = "";
        c.moveToFirst();
        if (c.moveToFirst()) {
            s = c.getString(c.getColumnIndex(TAB_Days + ""));
        }
        return s;
    }

    int ubdate_birthday(int id, String bday){

        SQLiteDatabase sq=this.getReadableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TAB_Days, bday);
        return sq.update(TABLE_NAME,cv,TAB_ID+"=?",new String[]{id+""});

    }

}