package com.sam.product.utils;


public class Constants {


    public static final String A_Z_ASC_KEY = "A-Z";
    public static final String A_Z_DESC_KEY = "Z-A";;
    public static final String BLANK = "";

    private Constants() {
    }

    public static final String ASC_SORT = "ASC";
    public static final String DESC_SORT = "DESC";
    public static final String ATTRIBUTE_DEFAULT = "id";
    public static final String DEFAULT_MAX_NO_OF_ROWS = "20";
    public static final String DEFAULT_PAGE = "0";
    public static final String DELIMITER_ATTRIBUTER = ";";
    public static final long STATISTIC_EVALUATION = 6;
    public static final int DEFAULT_PAGE_LOAD = 0;
    public static final int DEFAULT_SIZE = 10;


    /**
     * Type Report
     */
    public static final int INCOME_TYPE = 1;
    public static final int SAVING_TYPE = 2;
    public static final int PAYMENT_TYPE = 3;


    /**
     * Action
     */

    public static final String ADD_ACTION = "add";
    public static final String UPDATE_ACTION = "update";
    public static final String DELETE_ACTION = "delete";

    /**
     * Define message for 400 error code
     */
    public static final String CAN_NOT_BE_FOUND_ENTITY_MESSAGE = "Cannot be found entity";
    public static final String REPORT_TYPE_DUPLICATE = "Report type name is exist";



    // order by
    public static final String NAME_ASC_KEY = "fullName_asc";
    public static final String NAME_DESC_KEY = "fullName_desc";
    public static final String DATE_ASC_KEY = "createdDate_asc";
    public static final String DATE_DESC_KEY = "createdDate_desc";


    /**
     * Define message for 409 error code
     */
    public static final String DUPLICATE_DATA_MESSAGE = "A conflict data is ";

    /**
     * DateTime
     */
    public static final String SIMPLE_DATE_FORMAT = "dd-MM-yyyy";
    public static final String TIME_ZONE = "Asia/Ho_Chi_Minh";


}
