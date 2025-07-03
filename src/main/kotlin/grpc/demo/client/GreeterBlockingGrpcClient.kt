package grpc.demo.client

import io.grpc.examples.helloworld.GreeterGrpc.GreeterBlockingStub
import org.springframework.stereotype.Component

//@Component
class GreeterBlockingGrpcClient(private val stub: GreeterBlockingStub) {
}