package hwtts.economo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kerne_000 on 20.07.2015.
 */
public class DataBase extends SQLiteOpenHelper {
    public static final String PATH_DATABASE = "datacvn.db";
    public static final String TABLE_NAME = "all_values";
    public static final String PERSENTAGE_CREDIT = "percentage_credit";
    public static final String PERSENTAGE_INSURANCE = "percentage_insurance";
    public static final String INFLATION = "inflation";
    public static final String COMMISSIONS = "commisions";

    public DataBase(Context context) {
        super(context, PATH_DATABASE, null, 2);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + PERSENTAGE_CREDIT + " INTEGER, " + PERSENTAGE_INSURANCE + " INTEGER, " + INFLATION + " INTEGER, " + COMMISSIONS + " INTEGER);");
        ContentValues cv = new ContentValues();
        cv.put(PERSENTAGE_CREDIT, 0);
        cv.put(COMMISSIONS, 0);
        cv.put(INFLATION, 0);
        cv.put(PERSENTAGE_INSURANCE, 0);
        db.insert(TABLE_NAME, INFLATION, cv);
        db.insert(TABLE_NAME, COMMISSIONS, cv);
        db.insert(TABLE_NAME, PERSENTAGE_CREDIT, cv);
        db.insert(TABLE_NAME, PERSENTAGE_INSURANCE, cv);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
