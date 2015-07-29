package hwtts.economo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by kerne_000 on 16.07.2015.
 */
public class MainActivity extends Activity {
    private final String[] array = {"First", "Second", "Third"};
    DataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Spinner spinner = (Spinner) findViewById(R.id.sRegion);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        initToolbar();
    }

    private void initDataBase() {
        db = new DataBase(this);
        SQLiteDatabase sdb;
        sdb = db.getWritableDatabase();
        TextView tv = (TextView) findViewById(R.id.tvLastUpdate);
        if (db != null) {
            Cursor c = sdb.query(DataBase.TABLE_NAME, new String[]{
                            DataBase.COMMISSIONS, DataBase.PERSENTAGE_INSURANCE, DataBase.INFLATION, DataBase.PERSENTAGE_CREDIT, DataBase.COMMISSIONS}, null,
                    null,
                    null,
                    null,
                    null
            );
            c.moveToFirst();
            tv.setText(c.getInt(c.getColumnIndex(DataBase.INFLATION)) + "");
        } else {
           tv.setText("ХМ");
        }
    }

    //private boolean dataBaseExists() //-check existence DataBase on device


    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.inflateMenu(R.menu.menu);
    }

    public void onClickMenu(MenuItem mi) {
        switch (mi.getItemId()) {
            case (R.id.settings): {
                //--INTENT TO SETTINGS ACTIVITY
            }
        }
    }

    public void onClick(View v) {
    switch (v.getId()) {
        case R.id.bUpgradeDataBase: {
            initDataBase();
        }

    }
    }



}

