package com.jd.tms.util;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:11
 */
public class StringUtil {
    /**
     * 判断是否为空字符串最优代码
     * @param str
     * @return 如果为空，则返回true
     */
    public static boolean isBlank(String str){
        return str == null || str.trim().length() == 0;
    }

    /**
     * 判断字符串是否非空
     * @param str 如果不为空，则返回true
     * @return
     */
    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }
}
