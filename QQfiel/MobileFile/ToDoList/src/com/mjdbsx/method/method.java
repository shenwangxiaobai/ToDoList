package com.mjdbsx.method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class method {
    private static String driver;//连接数据库的驱动
    private static String url;
    private static String username;
    private static String password;

    static {
        driver = "com.mysql.jdbc.Driver";//需要的数据库驱动
        url = "jdbc:mysql://localhost:3306/mjdbsx?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";//数据库名路径
        username = "root";
        password = "1234";
    }

    //新建待办事项Id后三位
    public String addId(String[] dbsxid, String phonenumber) {
        int idnumber = 0;
        String aa = "";
        System.out.println(dbsxid==null);
        if (dbsxid == null) {
            aa = phonenumber + "000";
            System.out.println(phonenumber);
            return aa;
        } else {
            System.out.println(dbsxid.length);
            int[] id = new int[dbsxid.length];
            System.out.println(id[0]);
            int idi = 0;//待办事项id的数字
            int max = -1;//查找所存在的id的最大值
            //存储待办事项Id后三位数据
            for (String number : dbsxid) {
                System.out.println(number+"number");
                String needlastthree = number.substring(number.length()-3,number.length());
                System.out.println(needlastthree+"substring");
                int b = Integer.parseInt(needlastthree);
                id[idi] = b % 1000;
                System.out.println(id[idi]);
                if (id[idi] > max) {
                    //赋最大值
                    max = id[idi];
                }
                idi++;
            }
            System.out.println(max + "===" + id.length);
            if (id.length == max + 1) {
                max = max + 1;
                idnumber = max;
            } else {
                int i = 0;
                while (i < max) {
                    int j = 0;
                    int id_tag = 0;
                    while (j < id.length) {
                        if (id[j] == i) {
                            id_tag = 1;
                        }
                        j++;
                        if (j == id.length && id_tag == 0) {
                            idnumber = i;
                        }
                    }
                    i++;
                }
            }
        }
        if (idnumber < 10)
            aa = phonenumber + "00" + idnumber;
        if (idnumber > 9 && idnumber < 100)
            aa = phonenumber + "0" + idnumber;
        if (idnumber > 99 & idnumber < 1000)
            aa = phonenumber + idnumber;
        return aa;
    }

    /*
     *开启数据库
     */
    public Connection open() {
        try {
            Class.forName(driver);
            return (Connection) DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 关闭数据库
     */
    public void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //获取当前月份的第一天和最后一天
    public Timestamp[] startAndEnd(String date) {
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        String startdate = "";
        String enddate = "";
        Timestamp[] dates = new Timestamp[2];
        if (month != 2) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (month < 10) {
                     startdate = year + "-0" + month + "-01";
                     enddate = year + "-0" + month + "-31";
                } else {
                     startdate = year + "-" + month + "-01";
                     enddate = year + "-" + month + "-31";
                }
            } else {
                if (month < 10) {
                     startdate = year + "-0" + month + "-01";
                     enddate = year + "-0" + month + "-30";
                } else {
                     startdate = year + "-" + month + "01";
                     enddate = year + "-" + month + "-30";
                }
            }
        } else {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                 startdate = year + "-0" + month + "-01";
                 enddate = year + "-0" + month + "-29";
            } else {
                 startdate = year + "-0" + month + "-01";
                 enddate = year + "-0" + month + "-28";
            }
        }
        System.out.println(startdate+"------"+enddate);
        //注意月份是MM
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp start = Timestamp.valueOf( startdate+" 00:00:00");
        Timestamp starttime = new Timestamp(start.getTime());
        Timestamp end = Timestamp.valueOf( enddate+" 23:59:59");
        Timestamp endtime = new Timestamp(end.getTime());
            dates[0] = starttime;
            dates[1] = endtime;
    return dates;
    }
}
