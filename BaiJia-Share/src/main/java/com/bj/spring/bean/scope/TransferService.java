package com.bj.spring.bean.scope;

import org.springframework.stereotype.Service;

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
public interface TransferService {

    /**
     * 转账
     * @param accountId
     * @param anotherAccountId
     */
    void tranfer(String accountId, String anotherAccountId);

    /**
     * 初始化bean
     */
    void initTransferRecord();
}
