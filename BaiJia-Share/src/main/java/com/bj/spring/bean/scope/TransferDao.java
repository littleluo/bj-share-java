package com.bj.spring.bean.scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
@Repository
public class TransferDao {

    public TransferDao(){
        log.info("初始化transferDao bean... ...");
    }

    /**
     * 保存交易记录
     * @param transferRecords
     */
    public void saveRecords(TransferRecords transferRecords){
        log.info("接收到的交易记录：" + transferRecords.toString());
    }
}
