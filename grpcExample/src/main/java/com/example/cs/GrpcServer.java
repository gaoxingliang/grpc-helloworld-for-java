package com.example.cs;

import io.grpc.*;

public class GrpcServer {
    public static void main(String[] args) throws Exception{
        Server server = ServerBuilder.forPort(7070)
                .addService(new MyUserServiceImpl())
                .build();
        server.start();
        System.out.println("server start at 7070");
        server.awaitTermination();
    }
}
