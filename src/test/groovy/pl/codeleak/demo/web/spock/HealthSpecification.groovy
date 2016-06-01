package pl.codeleak.demo.web.spock

import com.kdn.ecsi.epengine.Application
import com.kdn.ecsi.epengine.support.ApplicationTest
import groovyx.net.http.RESTClient
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = Application.class)
@ApplicationTest
class HealthSpecification extends Specification {

    /*
    def "Should return that Jersey is Up and Running"() {
        setup:
        def client = new RESTClient("http://localhost:9000")
        client.auth.basic("demo", "123")

        when:
        def response = client.get(path: "/health")

        then:
        with(response) {
            status == 200
        }

        with(response.data) {
            "Jersey: Up and Running!"
        }
    }


    def "Should return that Spring MVC is Up and Running"() {
        setup:
        def client = new RESTClient("http://localhost:9000")
        client.auth.basic("demo", "123")

        when:
        def response = client.get(path: "/s/spring-health")

        then:
        with(response) {
            status == 200
        }

        with(response.data) {
            "Spring MVC: Up and Running!"
        }
    }
    */
}
