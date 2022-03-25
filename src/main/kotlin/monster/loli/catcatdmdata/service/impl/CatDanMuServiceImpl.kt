package monster.loli.catcatdmdata.service.impl

import monster.loli.catcatdmdata.entity.CatDanMu
import monster.loli.catcatdmdata.repository.CatDanMuRepository
import monster.loli.catcatdmdata.service.CatDanMuService
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList
import kotlin.collections.LinkedHashMap

@Service
class CatDanMuServiceImpl: CatDanMuService {
    @Autowired
    lateinit var catDanMuRepository: CatDanMuRepository
    @Autowired
    lateinit var mongoTemplate: MongoTemplate
    override fun listDanMu(clientId: String, roomId: Long): ArrayList<LinkedHashMap<String, Any>> {
        var s =  ArrayList<LinkedHashMap<String, Any>>();
        val findList = catDanMuRepository.findAll(PageRequest.of(0, 10))
        return s
    }

    override fun addDanMu(catDanMu: CatDanMu){
         mongoTemplate.insert(catDanMu)
    }
}