package br.com.bartie.apiTest.V1.data;

import java.util.Date;

import br.com.bartie.app.util.DateUtils;

public class BookData {

    public static String getAuthor(Long id)
    { return "Author#" + id; }

    public static String getTitle(Long id)
    { return "Title#" + id; }

    public static Date getLaunch(Long id)
    { return DateUtils.getDate(id.intValue()); }
   
    public static Double getPrice(Long id)
    { return 500D + (id * 35D); }
    
}
