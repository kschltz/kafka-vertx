package verticles.Kafka

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.kafka.client.producer.KafkaWriteStream.create
import org.apache.kafka.clients.producer.ProducerRecord
import verticles.kafkaConfig

class ProducerVerticle : AbstractVerticle(){
    override fun start(startFuture: Future<Void>?) {
     startFuture!!

        val eventBus = vertx.eventBus()

        val consumer = eventBus.consumer<String>(javaClass.name)

        consumer.handler{
            val producer = create<String, String>(vertx, kafkaConfig() as Map<String, Any>?)
            producer.write(ProducerRecord("strings.test",it.body()))
        }

        startFuture.complete()


    }

}