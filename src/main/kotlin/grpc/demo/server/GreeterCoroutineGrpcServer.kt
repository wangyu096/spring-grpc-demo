package grpc.demo.server

import io.grpc.examples.helloworld.GreeterGrpcKt
import io.grpc.examples.helloworld.HelloReply
import io.grpc.examples.helloworld.HelloRequest
import org.slf4j.LoggerFactory

//@Service
class GreeterCoroutineGrpcServer: GreeterGrpcKt.GreeterCoroutineImplBase() {
    override suspend fun sayHello(request: HelloRequest): HelloReply {
        logger.info("Received request: $request")
        return HelloReply.newBuilder().setMessage("Hello ${request.name}").build()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }
}