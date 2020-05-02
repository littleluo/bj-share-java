package com.bj.spring.config;

import java.util.ResourceBundle;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/5/2 17:54
 * @serial: ----- 变更时间 变更者 变更说明
 */
public class BJPropertiesConfig {
    private ResourceBundle resource;
    public final static String DB_URL = "bj-system.db.url";
    public final static String DB_PWD = "bj-system.db.pwd";
    public final static String DB_USER = "bj-system.db.user";

    public String getValue(String key) {
        return resource.getString(key);
    }

    private BJPropertiesConfig() {
        resource = ResourceBundle.getBundle("bj");
    }

    private static class SingletonHandler {

        private static BJPropertiesConfig instance;

        static {

            instance = new BJPropertiesConfig();
        }

        public static BJPropertiesConfig getInstance() {
            return instance;
        }

    }

    public static BJPropertiesConfig getInstance() {
        return SingletonHandler.getInstance();
    }
}
