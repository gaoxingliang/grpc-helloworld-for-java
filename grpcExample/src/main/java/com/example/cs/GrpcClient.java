package com.example.cs;

import com.example.grpc.user.*;
import io.grpc.*;

public class GrpcClient {
    public static void main(String[] args) throws Exception {
        ManagedChannel ch = ManagedChannelBuilder.forAddress("localhost", 7070)
                .usePlaintext().build();
        UserGrpc.UserBlockingStub stub = UserGrpc.newBlockingStub(ch);

        UserOuterClass.APIResponse resp = stub.login(UserOuterClass.LoginRequest.newBuilder().setUsername("hello").setPassword("world").build());
        System.out.println("Response " + resp);
        ch.shutdown();
    }
}
