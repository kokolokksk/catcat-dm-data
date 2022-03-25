package monster.loli.catcatdmdata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(excludeName = ["DataSourceAutoConfiguration"])
class CatCatDmDataApplication

fun main(args: Array<String>) {
	runApplication<CatCatDmDataApplication>(*args)
}
