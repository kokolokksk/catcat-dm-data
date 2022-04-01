package monster.loli.catcatdmdata.service.impl

import monster.loli.catcatdmdata.entity.CatClient
import monster.loli.catcatdmdata.service.WebLoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class WebLoginServiceImpl: WebLoginService {
    @Autowired
    lateinit var mongoTemplate: MongoTemplate

    override fun loginWeb(clientId: String): MutableList<CatClient> {
        var query: Query = Query.query(Criteria.where("clientId").`is`(clientId))
        return mongoTemplate.find(query, CatClient::class.java)
    }
}