package grpc.demo.config

import io.grpc.examples.helloworld.GreeterGrpcKt
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.grpc.client.CoroutineStubFactory
import org.springframework.grpc.client.ImportGrpcClients


@Configuration(proxyBeanMethods = false)
@ImportGrpcClients(
    target = "helloworld",
    basePackages = ["io.grpc.examples"]
)
//@ImportGrpcClients(
//    target = "helloworld",
////    basePackages = ["io.grpc.examples"],
//    types = [GreeterGrpcKt.GreeterCoroutineStub::class],
//    factory = CoroutineStubFactory::class
//)
class GrpcClientConfiguration {

    /**
     * Register CoroutineStubFactory to ApplicationContext
     */
    @Bean
    fun greeterCoroutineStub() = CoroutineStubFactory()
}
