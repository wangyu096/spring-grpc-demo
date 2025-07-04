package grpc.demo.client

import io.grpc.examples.helloworld.GreeterGrpcKt
import org.springframework.stereotype.Component

//@Component
class GreeterCoroutineGrpcClient(private val stub: GreeterGrpcKt.GreeterCoroutineStub) {
}