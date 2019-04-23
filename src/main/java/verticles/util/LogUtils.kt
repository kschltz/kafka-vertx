package verticles.util

import io.vertx.core.AbstractVerticle
import io.vertx.core.logging.Logger
import io.vertx.core.logging.LoggerFactory.getLogger


fun <T : AbstractVerticle> T.logger(): Logger = getLogger(javaClass)