package grails.external.config.lettuce

import io.lettuce.core.api.StatefulRedisConnection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier

class MyController {

    @Qualifier('io.lettuce.core.api.StatefulRedisConnection(Primary)')
    @Autowired
    StatefulRedisConnection statefulRedisConnection

    def index() {
        render statefulRedisConnection.sync().ping()
    }
}
