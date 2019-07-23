package com.example.demo.service;

import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

/**
 *
 * @CreatTime 2019/7/22
 **/
@Service
public class ClientService {

    public String get(String s) throws Exception {
        Test.Client client = ThriftClient.getClient();
        String result = client.setValue(s);
        return result;
    }

    @PreDestroy
    public void destory() {
        ThriftClient.destory();
    }

}
