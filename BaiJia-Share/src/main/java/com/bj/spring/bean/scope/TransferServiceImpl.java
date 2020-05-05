package com.bj.spring.bean.scope;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/5/4 18:12
 * @serial: ----- 变更时间 变更者 变更说明
 */
@Slf4j
public class TransferServiceImpl implements TransferService{

    private  TransferDao transferDao;
    private TransferRecords transferRecords;

    public  TransferServiceImpl(TransferRecords transferRecords, TransferDao transferDao){
        this.transferDao = transferDao;
        this.transferRecords = transferRecords;
        log.info("初始化transferService bean... ...");
        this.tranfer(this.transferRecords.getAccountId(), this.transferRecords.getAnotherAccountId());
    }

    @Override
    public void tranfer(String accountId, String anotherAccountId) {
        log.info("{}账户转给{}账户成功... ...", accountId, anotherAccountId);
    }
}
