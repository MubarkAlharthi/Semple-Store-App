package com.educationalapp.android.inventoryappstage1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.educationalapp.android.inventoryappstage1.data.storeContract.ProductEntry;

public class PrudectDbHelper extends SQLiteOpenHelper {

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "Prudect.db";
    private static final int DATABASE_VERSION = 1;

    public PrudectDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_Proudect_TABLE =
                "CREATE TABLE " + ProductEntry.TABLE_NAME + " ("
                        + ProductEntry.COLUMN_product_NAME + " TEXT NOT NULL, "
                        + ProductEntry.COLUMN_product_PRICE + " INTEGER, "
                        + ProductEntry.COLUMN_product_QUANTITY + " INTEGER NOT NULL DEFAULT 0, "
                        + ProductEntry.COLUMN_product_IMAGE + " BLOB, "
                        + ProductEntry.COLUMN_product_SUPPLIER_NAME + " TEXT,"
                        + ProductEntry.COLUMN_product_SUPPLIER_EMAIL + " TEXT,"
                        + ProductEntry.COLUMN_product_SUPPLIER_PHONE_NUMBER + " INTEGER);";
        db.execSQL(SQL_CREATE_Proudect_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dp, int oldVersion, int newVersion) {

    }
}
