package com.monical.groovy.learning.groovyInAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by leoxie on 1/8/18.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum AjaxCodeEnum {
    UNKNOWN(0, "未知"),
    PIGEON_INVOKE_ERROR(1101, "pigeon服务调用异常"),
    UPDATE_ERROR(1102, "更新数据异常"),
    INSERT_ERROR(1103, "插入数据异常"),
    CONCURRENT_ERROR(1104, "并发异常"),
    DATA_QUERY_ERROR(1105, "未查询到参数对应的值"),
    PARAMETER_ERROR(1106, "请求参数有误");

    private int code;
    private String desc;

    public static AjaxCodeEnum valueOf(int value) {
        for (AjaxCodeEnum item : AjaxCodeEnum.values()) {
            if (item.code == value) {
                return item;
            }
        }
        return UNKNOWN;
    }
}
