package com.hangjiang.threads.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by jianghang on 2017/11/27.
 */
public class PCDataFactory implements EventFactory<PCData>{
    @Override
    public PCData newInstance() {
        return new PCData();
    }
}
