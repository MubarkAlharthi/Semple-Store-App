package com.educationalapp.android.inventoryappstage1.data;

import android.provider.BaseColumns;

public class storeContract {

    public storeContract() {
    }

    public static final class ProductEntry implements BaseColumns {
        public final static String TABLE_NAME = "Productinfo";
        public final static String COLUMN_product_NAME = "Name";
        public final static String COLUMN_product_IMAGE = "Image";
        public final static String COLUMN_product_QUANTITY = "quantity";
        public final static String COLUMN_product_PRICE = "price";
        public final static String COLUMN_product_SUPPLIER_NAME = "supplier_name";
        public final static String COLUMN_product_SUPPLIER_EMAIL = "supplier_email";
        public final static String COLUMN_product_SUPPLIER_PHONE_NUMBER = "supplier_Phone_Number";
    }

}
