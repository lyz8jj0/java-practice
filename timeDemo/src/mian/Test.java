package mian;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/27.
 */
public class Test {

    public boolean compare(String time1, String time2) throws ParseException {
        //如果想比较日期则写成"yyyy-MM-dd"就可以了 ,H就24小时，h是12小时
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将字符串形式的时间转化为Date类型的时间
        Date a = sdf.parse(time1);
        Date b = sdf.parse(time2);
        long diff = b.getTime() - a.getTime();
        int minutes = (int) diff / (1000 * 60); //将相差的时间转换为分钟
        if (minutes > 10) {
            return true;
        } else {
            return false;
        }
        /*也可以这么比较
        if(a.before(b))
            return true;
        else
            return false;
            */

    }

    public static void main(String[] args) throws ParseException {
        Test test = new Test();
        boolean result = test.compare("2018-7-27 11:49:30", "2018-7-27 12:56:31");
        System.out.println(result);
    }
}
