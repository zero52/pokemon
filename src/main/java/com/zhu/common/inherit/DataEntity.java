package com.zhu.common.inherit;

public abstract class DataEntity<T> {

    protected String id;
    protected String delFlag;

    /**
     * 当前实体分页对象
     */

    protected DataEntity() {
        this.delFlag = DEL_FLAG_NORMAL;
    }


    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";
}
