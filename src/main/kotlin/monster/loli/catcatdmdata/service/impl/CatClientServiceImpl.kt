package monster.loli.catcatdmdata.service.impl

import monster.loli.catcatdmdata.entity.CatClient
import monster.loli.catcatdmdata.service.CatClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class CatClientServiceImpl: CatClientService {
    @Autowired
    lateinit var mongoTemplate: MongoTemplate


    override fun addClientId(catClient: CatClient){
         mongoTemplate.insert(catClient)
    }
}