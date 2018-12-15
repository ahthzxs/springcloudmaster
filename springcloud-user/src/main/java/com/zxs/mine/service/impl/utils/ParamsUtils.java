package com.zxs.mine.service.impl.utils;

import java.util.ArrayList;
import java.util.List;

public   class ParamsUtils {

    public static List getKeyListByIdStr(String ids) {
        List list = new ArrayList();

        for (String s : ids.replace("[","").replace("]","").split(",")){
            list.add(Integer.valueOf(s));
        }

        return  list;
    }


    public static String getSqlKeysStrByIdStr(String ids) {
        String SqlKeys = "";

        for (String s : ids.replace("[","").replace("]","").split(",")){
            SqlKeys += "'"+s+"'" ;
        }

        return    "("+SqlKeys+")";
    }



}
