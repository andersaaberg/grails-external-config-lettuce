package grails.external.config.lettuce

import grails.testing.mixin.integration.Integration
import io.micronaut.http.client.DefaultHttpClient
import io.micronaut.http.client.RxHttpClient
import redis.embedded.RedisServer
import spock.lang.Specification

@Integration
class MyControllerSpec extends Specification {

    void "test that lettuce can be injected"() {

        given:
        RedisServer redisServer = new RedisServer(9093)
        redisServer.start()
        RxHttpClient rxHttpClient = new DefaultHttpClient(new URL("http://localhost:${serverPort}"))

        expect:
        rxHttpClient.toBlocking().retrieve("/my") == 'PONG'

        cleanup:
        redisServer.stop()
    }
}
