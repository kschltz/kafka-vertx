package verticles

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.kafka.client.consumer.KafkaConsumer.create

class ConsumerVerticle : AbstractVerticle() {

    override fun start(startFuture: Future<Void>) {

        val consumer = create<String, String>(vertx, kafkaConfig())

        consumer.subscribe("strings.test")
        consumer.handler {
            print("Some serious message consumption going on here: ${it.value()}")
        }
        startFuture.complete()

    }
}