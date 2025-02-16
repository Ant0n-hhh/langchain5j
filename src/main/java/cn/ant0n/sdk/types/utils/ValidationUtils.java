package cn.ant0n.sdk.types.utils;


import org.apache.commons.lang.StringUtils;

import static cn.ant0n.sdk.types.Exceptions.illegalArgument;

public class ValidationUtils {

    public static String ensureNotBlank(String text){
        if(StringUtils.isBlank(text)){
            throw illegalArgument("%s cannot be null or blank", text);
        }
        return text;
    }
}
