package com.educationalapp.android.inventoryappstage1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.educationalapp.android.inventoryappstage1.data.PrudectDbHelper;
import com.educationalapp.android.inventoryappstage1.data.storeContract.ProductEntry;


public class MainActivity extends AppCompatActivity {
    private PrudectDbHelper mDbHelper;
    TextView displayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbHelper = new PrudectDbHelper(this);
        displayView = (TextView) findViewById(R.id.text);
        insertData();
    }

    private void insertData() {

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ProductEntry.COLUMN_product_NAME, "Family ");
        values.put(ProductEntry.COLUMN_product_PRICE, 54);
        values.put(ProductEntry.COLUMN_product_QUANTITY, 4);
        values.put(ProductEntry.COLUMN_product_SUPPLIER_PHONE_NUMBER, 543453);
        db.insert(ProductEntry.TABLE_NAME, null, values);

        values.put(ProductEntry.COLUMN_product_NAME, "story");
        values.put(ProductEntry.COLUMN_product_PRICE, 89);
        values.put(ProductEntry.COLUMN_product_QUANTITY, 4);
        values.put(ProductEntry.COLUMN_product_SUPPLIER_PHONE_NUMBER, 543453);
        db.insert(ProductEntry.TABLE_NAME, null, values);
        queryData();
    }

    private Cursor queryData() {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                ProductEntry.COLUMN_product_NAME,
                ProductEntry.COLUMN_product_PRICE};
        Cursor cursor = db.query(
                ProductEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        int nameColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_product_NAME);
        int priceColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_product_PRICE);
        displayView.setText(ProductEntry.COLUMN_product_NAME + "   " + ProductEntry.COLUMN_product_PRICE + "\n\n");
        try {
            while (cursor.moveToNext()) {
                String currentName = cursor.getString(nameColumnIndex);
                double currentPrice = cursor.getDouble(priceColumnIndex);
                displayView.append(currentName + "    " + currentPrice + "\n");
            }

        } finally {
            cursor.close();
        }
        // The sort order
        return cursor;
    }
}
