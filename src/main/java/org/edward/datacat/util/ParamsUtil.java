package org.edward.datacat.util;

public class ParamsUtil {
    public static String getValueByKey(String[] args, String key, String prefix) {
        if(args==null || args.length==0) {
            return null;
        }
        String temp = prefix + key + "=";
        for(int i=0; i<args.length; i++) {
            String arg = args[i];
            if(arg.startsWith(temp)) {
                return arg.substring(temp.length());
            }
        }
        return null;
    }
}