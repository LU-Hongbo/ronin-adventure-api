package ronin.adventure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RobinAdventureApplication

fun main(args: Array<String>) {
    runApplication<RobinAdventureApplication>(*args)
}
