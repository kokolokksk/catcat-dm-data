package monster.loli.catcatdmdata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication(excludeName = ["DataSourceAutoConfiguration"])
@EnableMongoRepositories
class CatCatDmDataApplication

fun main(args: Array<String>) {
	runApplication<CatCatDmDataApplication>(*args)
}
