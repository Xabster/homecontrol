package com.example.homecontrol.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.example.homecontrol.database.entities.Outlet;

import java.util.ArrayList;
import java.util.List;

public class OutletDAO {
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = {SQLiteHelper.COLUMN_ID, SQLiteHelper.COLUMN_DESCRIPTION};

    public OutletDAO(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Outlet createOutlet(String description, long id) {
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_DESCRIPTION, description);
        values.put(SQLiteHelper.COLUMN_ID, id);
        long insertId = database.insert(SQLiteHelper.TABLE_OUTLET, null, values);
        Cursor cursor = database.query(SQLiteHelper.TABLE_OUTLET, allColumns, SQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Outlet newOutlet = cursorToOutlet(cursor);
        cursor.close();
        return newOutlet;
    }

    public void deleteOutlet(Outlet outlet) {
        long id = outlet.getOutletID();
        System.out.println("Outlet deleted with id: " + id);
        database.delete(SQLiteHelper.TABLE_OUTLET, SQLiteHelper.COLUMN_ID + " = " + id, null);
    }

    public List<Outlet> getAllOutlets() {
        List<Outlet> outlets = new ArrayList<Outlet>();

        Cursor cursor = database.query(SQLiteHelper.TABLE_OUTLET, allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Outlet outlet = cursorToOutlet(cursor);
            outlets.add(outlet);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return outlets;
    }

    private Outlet cursorToOutlet(Cursor cursor) {
        Outlet outlet = new Outlet();
        outlet.setOutletID(cursor.getLong(0));
        outlet.setDescription(cursor.getString(1));
        return outlet;
    }
}