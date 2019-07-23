package com.example.demo.service;

import org.apache.thrift.TException;
/**
 *
 * @CreatTime 2019/7/22
 **/
public class ThriftTestService implements Test.Iface {

    @Override
    public String setValue(String data) throws TException {
        return "setvalue:" + data;
    }
}
