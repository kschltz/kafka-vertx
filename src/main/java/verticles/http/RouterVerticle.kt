package verticles.http

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.http.HttpHeaders
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router.router
import verticles.Kafka.ProducerVerticle

class RouterVerticle : AbstractVerticle() {

    override fun start(start: Future<Void>) {
        val router = router(vertx)

        router.route(HttpMethod.PUT, "/").handler { context ->
            context.request().bodyHandler { bodyBuffer ->

                val message = bodyBuffer.toString()
                vertx.eventBus().publish(ProducerVerticle::class.java.name, message)
            }
            context.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            context.response().setStatusCode(200).end("Message submitted")

        }

        vertx.createHttpServer()
            .requestHandler(router)
            .listen(8888)

        start.complete()

    }
}