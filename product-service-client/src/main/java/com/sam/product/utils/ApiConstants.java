package com.sam.product.utils;

public class ApiConstants {



    private ApiConstants() {
    }

    public static final String API_VERSION_1 = "api/v1";
    public static final String ID = "/{id}";
    public static final String PROJECT_STATUS = "/{projectStatus}";

    /**
     * categories
     */
    public static final String CATEGORIES_END_POINT = "/categories";
    public static final String CATEGORIES_BY_ID_END_POINT = CATEGORIES_END_POINT + ID;
    public static final String CATEGORIES_FOR_FILTER_END_POINT = CATEGORIES_END_POINT + "/filter/" + ID;
    public static final String CATEGORIES_BY_NAME_END_POINT = CATEGORIES_END_POINT + "/{name}";
    public static final String CATEGORIES_SEARCH_BY_NAME_END_POINT = CATEGORIES_END_POINT + "/search";


    /**
     * Product Endpoint
     */
    public static final String PRODUCTS_END_POINT = "/products";
    public static final String PRODUCT_END_POINT = "/product";
    public static final String PRODUCT_BY_ID_END_POINT = PRODUCT_END_POINT + "/{id}";
    public static final String PRODUCT_BY_NAME_END_POINT = PRODUCT_END_POINT + "/{name}";
    public static final String PRODUCT_BY_COLOR_END_POINT = PRODUCT_END_POINT + "/color";
    public static final String PRODUCT_BY_BRANCH_END_POINT = PRODUCT_END_POINT + "/branch";
    public static final String PRODUCT_FILTER_BY_PRICE_END_POINT = PRODUCT_END_POINT + "/filter/price";


}
