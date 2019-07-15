package grails.external.config.lettuce

import org.springframework.beans.factory.annotation.Value

class ExtraController {

    @Value('${redis.uri}')
    String redisUri

    def index() {
        render redisUri
    }
}
