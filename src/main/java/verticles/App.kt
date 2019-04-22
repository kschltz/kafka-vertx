package verticles

import io.vertx.core.Vertx

fun main(args: Array<String>) {
    println("App started")
    val vertx = Vertx.vertx()

    vertx.deployVerticle(ProducerVerticle::class.java.name)

    vertx.createHttpServer()
        .requestHandler {
            val response = it.response()
            response.putHeader("content-type","text/plain")

            response.setStatusCode(200)
            vertx.eventBus().publish(ProducerVerticle::class.java.name,"smurfs")

            response.end("Smurfs")
        }
        .listen(8008)



}