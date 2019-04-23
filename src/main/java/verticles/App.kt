package verticles

import io.netty.util.internal.logging.InternalLoggerFactory.setDefaultFactory
import io.netty.util.internal.logging.Log4JLoggerFactory.INSTANCE
import io.vertx.core.Vertx
import verticles.Kafka.ConsumerVerticle
import verticles.Kafka.ProducerVerticle
import verticles.http.RouterVerticle

fun main() {
    println("App started")
    val vertx = Vertx.vertx()
    setDefaultFactory(INSTANCE)

    vertx.deployVerticle(ProducerVerticle::class.java.name)
    vertx.deployVerticle(ConsumerVerticle::class.java.name)
    vertx.deployVerticle(RouterVerticle::class.java.name)

}