package com.example.cs;

import com.example.grpc.common.vo.*;
import com.example.grpc.user.*;
import io.grpc.stub.*;

public class MyUserServiceImpl extends UserGrpc.UserImplBase {
    @Override
    public void login(UserOuterClass.LoginRequest request, StreamObserver<UserOuterClass.APIResponse> responseObserver) {
        UserOuterClass.APIResponse.Builder resp = UserOuterClass.APIResponse.newBuilder();
        if (request.getUsername().equals(request.getPassword())) {
            resp.setResponseCode(0);
            resp.setResponsemessage("OK");
        } else {
            resp.setResponseCode(1);
            resp.setResponsemessage("FAIL");
        }
        responseObserver.onNext(resp.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(Vo.Empty request, StreamObserver<UserOuterClass.APIResponse> responseObserver) {
        // 没实现。
    }
}
