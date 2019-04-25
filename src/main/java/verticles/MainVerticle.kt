package verticles

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import verticles.Kafka.ConsumerVerticle
import verticles.Kafka.ProducerVerticle
import verticles.http.RouterVerticle

class MainVerticle : AbstractVerticle() {


    override fun start(startFuture: Future<Void>) {
        println("App started")

        vertx.deployVerticle(ProducerVerticle::class.java.name)
        vertx.deployVerticle(ConsumerVerticle::class.java.name)
        vertx.deployVerticle(RouterVerticle::class.java.name)
        startFuture.complete()
    }

}