package grpc.demo.config

import io.micrometer.core.instrument.kotlin.ObservationCoroutineContextServerInterceptor
import io.micrometer.observation.ObservationRegistry
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.grpc.autoconfigure.server.ConditionalOnGrpcServerEnabled
import org.springframework.grpc.server.GlobalServerInterceptor

@AutoConfiguration(afterName = ["org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration"])
@ConditionalOnGrpcServerEnabled
@ConditionalOnClass(ObservationRegistry::class, ObservationCoroutineContextServerInterceptor::class)
@ConditionalOnBean(ObservationRegistry::class)
@ConditionalOnProperty(name = ["spring.grpc.server.observation.enabled"], havingValue = "true", matchIfMissing = true)
class GrpcServerCoroutineObservationAutoConfiguration {
    @GlobalServerInterceptor
    @Bean
    fun observationCoroutineContextServerInterceptor(observationRegistry: ObservationRegistry) =
        ObservationCoroutineContextServerInterceptor(observationRegistry)
}