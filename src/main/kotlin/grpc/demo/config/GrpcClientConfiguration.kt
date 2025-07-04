package grpc.demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.grpc.client.CoroutineStubFactory
import org.springframework.grpc.client.ImportGrpcClients


@Configuration(proxyBeanMethods = false)
@ImportGrpcClients(
    target = "helloworld",
    basePackages = ["io.grpc.examples"]
)
@ImportGrpcClients(
    target = "helloworld",
    basePackages = ["io.grpc.examples"],
    factory = CoroutineStubFactory::class
)
class GrpcClientConfiguration
