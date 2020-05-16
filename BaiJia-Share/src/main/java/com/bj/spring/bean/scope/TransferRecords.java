package com.bj.spring.bean.scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
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
 * @since: 2020/5/4 18:02
 * @serial: ----- 变更时间 变更者 变更说明
 */
@Slf4j
@Component
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TransferRecords {

    private String accountId;

    private String anotherAccountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAnotherAccountId() {
        return anotherAccountId;
    }

    public void setAnotherAccountId(String anotherAccountId) {
        this.anotherAccountId = anotherAccountId;
    }

    public TransferRecords(){
        log.info("初始化transferRecords bean... ...");
    }

  /*  @Override
    public String toString(){
        return String.format("%s账户转给%s账户成功... ...", this.accountId, this.anotherAccountId);
    }*/
}
