package verticles

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.kafka.client.producer.KafkaWriteStream.create
import org.apache.kafka.clients.producer.ProducerRecord

class ProducerVerticle : AbstractVerticle(){
    override fun start(startFuture: Future<Void>?) {
     startFuture!!

        val eventBus = vertx.eventBus()

        val consumer = eventBus.consumer<String>(ProducerVerticle::class.java.name)

        consumer.handler{
            val producer = create<String, String>(vertx, kafkaConfig())
            producer.write(ProducerRecord("strings.test",it.body()))
        }

        startFuture.complete()


    }

}