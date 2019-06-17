package com.itheima.ssm.utils;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dataUtils {
    public static String Data2utilss(Date data ,String parr){
        SimpleDateFormat ss = new SimpleDateFormat(parr);
        String format = ss.format(data);
        return format;
    }

    public static Date  Data2utils(String ss ,String parr) throws ParseException {
        SimpleDateFormat sss = new SimpleDateFormat(parr);
        Date parse = sss.parse(ss);
        return parse;
    }
}
