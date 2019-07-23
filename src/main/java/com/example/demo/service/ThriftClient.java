package com.example.demo.service;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 *
 * @CreatTime 2019/7/22
 **/
public class ThriftClient {
    private static volatile Test.Client client = null;
    private static volatile TTransport tTransport = null;
    private static volatile TProtocol protocol = null;

    private ThriftClient() {

    }

    public static void destory() {
        if (null != tTransport && tTransport.isOpen()) {
            tTransport.close();
        }
    }

    public static Test.Client getClient() {
        if (null == client) {
            synchronized (ThriftClient.class) {
                if (null == client) {
                    try {
                        tTransport = new TSocket("127.0.0.1", 8090);
                        tTransport.open();
                        protocol = new TBinaryProtocol(tTransport);
                        client = new Test.Client.Factory().getClient(protocol);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return client;
    }
}
