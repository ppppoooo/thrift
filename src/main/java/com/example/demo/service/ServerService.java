package com.example.demo.service;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 * @CreatTime 2019/7/22
 **/
@Service
public class ServerService {

    public static TServer server = null;

    @PostConstruct
    public void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TServerSocket serverSocket = new TServerSocket(8090);
                    TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
                    TProcessor processor = new Test.Processor(new ThriftTestService());
                    TThreadPoolServer.Args serverArgs = new TThreadPoolServer.Args(serverSocket);
                    serverArgs.processor(processor);
                    serverArgs.protocolFactory(factory);
                    TServer server = new TThreadPoolServer(serverArgs);
                    System.out.println("MyServer start");
                    server.serve();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @PreDestroy
    public void destroy() {
        if (null != server && server.isServing()) {
            server.stop();
        }
    }

}
