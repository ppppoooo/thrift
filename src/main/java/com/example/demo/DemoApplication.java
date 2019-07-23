package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        //不新建线程在这里初始化socket也可以
//		try {
//			TServerSocket serverSocket = new TServerSocket(8090);
//			TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
//			TProcessor processor = new Test.Processor(new ThriftTestService());
//			TThreadPoolServer.Args serverArgs = new TThreadPoolServer.Args(serverSocket);
//			serverArgs.processor(processor);
//			serverArgs.protocolFactory(factory);
//			TServer server = new TThreadPoolServer(serverArgs);
//			System.out.println("MyServer start");
//			server.serve();
//		}catch (Exception e){
//			e.printStackTrace();
//		}

    }

}
