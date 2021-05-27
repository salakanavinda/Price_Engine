package com.example.price.engine.config;

/**
 * Constants.
 *
 * @author Salaka, 5/26/2021 12:11 PM
 */
public final class Constants {

    /**
     * products types database properties.
     */
    public static final class ProductConstants {
        public static final String TABLE_NAME = "TBL_PRODUCT";
        public static final String REMARKS = "REMARKS";
        public static final String ID = "ID";
        public static final String NAME = "NAME";
        public static final String PRICE_PER_CARTON = "PRICE_PER_CARTON";
        public static final String UNIT_PER_CARTON = "UNIT_PER_CARTON";
        public static final String CARTON_WISE_DISCOUNT = "CARTON_WISE_DISCOUNT";
        public static final String SINGLE_UNIT_COMPENSATE_VALUE = "SINGLE_UNIT_COMPENSATE_VALUE";

    }

    /**
     * stocks types database properties.
     */
    public static final class StockConstants {
        public static final String TABLE_NAME = "TBL_STOCK";
        public static final String REMARKS = "REMARKS";
        public static final String ID = "ID";
        public static final String PRODUCT_ID = "PRODUCT_ID";
        public static final String CARTON_QTY = "CARTON_QTY";
        public static final String UNIT_QTY = "UNIT_QTY";
    }

    /**
     * product related request mappings.
     */
    public static final class ProductRequestMappings {
        public static final String PRODUCT_ROOT_PATH = "/products";
        public static final String PRODUCT_BY_ID = "/{id}";
    }

    /**
     * stock related request mappings.
     */
    public static final class StockRequestMappings {
        public static final String STOCK_ROOT_PATH = "/stocks";
        public static final String STOCK_BY_PRODUCT = "/{product_id}";
        public static final String PRICE = "/price";
    }
}
