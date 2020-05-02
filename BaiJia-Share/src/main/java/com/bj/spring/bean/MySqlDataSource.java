package com.bj.spring.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/5/2 17:34
 * @serial: ----- 变更时间 变更者 变更说明
 */
@Component("mySqlDataSource")
@Slf4j
public class MySqlDataSource {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void writePassword(){
        log.info("数据源密码==={}",this.password);
    }
}
