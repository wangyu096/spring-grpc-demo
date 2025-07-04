package grpc.demo.server

import io.grpc.examples.helloworld.GreeterGrpc
import io.grpc.examples.helloworld.HelloReply
import io.grpc.examples.helloworld.HelloRequest
import io.grpc.stub.StreamObserver
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

//@Service
class GreeterBlockingGrpcServer: GreeterGrpc.GreeterImplBase() {

    override fun sayHello(request: HelloRequest?, responseObserver: StreamObserver<HelloReply>?) {
        logger.info("Received request: $request")
        responseObserver?.onNext(HelloReply.newBuilder().setMessage("Hello ${request?.name}").build())
        responseObserver?.onCompleted()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }
}