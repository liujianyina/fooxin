package cn.fooxin.web.utils;

/**
 * 全局静态常量值
 * Created by liujianyin on 2017/11/17.
 */

public class Constant {

    public final static String TABLE_PREFIX = "jxda_";

    /**
     * session对象key
     */
    public final class SessionKey {
        /**
         * 当前登录用户
         */
        public static final String CURRENT_USER = "cn.yznu.jxda.session.user";

        /**
         * 当前登录用户菜单
         */
        public static final String AVAILABLE_MENU = "cn.yznu.jxda.session.available_menu";
    }


}
