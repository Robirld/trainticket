package com.trainticket.job;

import org.springframework.beans.factory.InitializingBean;

/**
 * @Author user
 * @Date 2020/12/28 5:19 PM
 * @Version 1.0
 */
public abstract class TtJob implements InitializingBean {

    abstract public void startJob();

    @Override
    public void afterPropertiesSet() throws Exception {
        this.startJob();
    }
}
