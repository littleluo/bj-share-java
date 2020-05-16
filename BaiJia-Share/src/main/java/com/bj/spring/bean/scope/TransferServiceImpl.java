package com.bj.spring.bean.scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
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
 * @since: 2020/5/4 18:12
 * @serial: ----- 变更时间 变更者 变更说明
 */
@Slf4j
@Service
public class TransferServiceImpl implements TransferService, ApplicationContextAware {


    @Autowired
    @Lazy
    private TransferRecords transferRecords;
    @Autowired
    private TransferDao transferDao;
    private ApplicationContext applicationContext;
    //private TransferRecords transferRecords;

    /*  public  TransferServiceImpl(TransferRecords transferRecords, TransferDao transferDao){
          this.transferDao = transferDao;
          this.transferRecords = transferRecords;
          log.info("初始化transferService bean... ...");
          this.tranfer(this.transferRecords.getAccountId(), this.transferRecords.getAnotherAccountId());
      }*/

  /*  public TransferServiceImpl(TransferDao transferDao) {
        this.transferDao = transferDao;
        log.info("初始化transferService bean... ...");
    }*/

    //@Lookup
    //public TransferRecords getTransferRecordsBean();

    @Override
    public void tranfer(String accountId, String anotherAccountId) {
        //log.info("{}账户转给{}账户成功... ...", accountId, anotherAccountId);
        //TransferRecords transferRecords = applicationContext.getBean(TransferRecords.class);
        //TransferRecords transferRecords = getTransferRecordsBean();
        transferRecords.setAccountId(accountId);
        transferRecords.setAnotherAccountId(anotherAccountId);
        transferDao.saveRecords(transferRecords);
    }

    @Override
    public void initTransferRecord(){
        log.info("@Lazy--->" + transferRecords);
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
