package com.lmig.ci.lmb.gi;

import com.lmig.ci.lmb.gi.dao.SettlementFileRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PaymentMain {
    private static final Logger logger = LoggerFactory.getLogger(PaymentMain.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext appContext = SpringApplication.run(PaymentMain.class, args);
        SettlementFileRepositoryImpl beanRepoImpl = (SettlementFileRepositoryImpl)appContext.getBean(SettlementFileRepositoryImpl.class);
        try{
            beanRepoImpl.writeSettlementFile();
        }catch (Exception ex1)
        {
            logger.error("writeFile",ex1.getMessage());
        }
    }
}