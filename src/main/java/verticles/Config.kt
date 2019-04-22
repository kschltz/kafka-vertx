package verticles

fun kafkaConfig(): MutableMap<String, Any> {
    var config = mutableMapOf<String, Any>()

    config["bootstrap.servers"] = "localhost:9092"
    config["key.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
    config["value.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
    config["value.deserializer"] = "org.apache.kafka.common.serialization.StringDeserializer"
    config["key.deserializer"] = "org.apache.kafka.common.serialization.StringDeserializer"
    config["acks"] = "1"
    return config
}
