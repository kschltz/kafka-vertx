package verticles.Kafka

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.kafka.client.consumer.KafkaConsumer.create
import verticles.kafkaConfig
import verticles.util.logger
import java.time.LocalTime.now

class ConsumerVerticle : AbstractVerticle() {


    override fun start(startFuture: Future<Void>) {

        val consumer = create<String, String>(vertx, kafkaConfig())

        consumer.handler {
            logger().info("\nConsuming message: ${it.value()}, time: ${now()}")
        }
        consumer.subscribe("strings.test")

        startFuture.complete()

    }
}