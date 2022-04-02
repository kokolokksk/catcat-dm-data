package monster.loli.catcatdmdata.service.impl

import monster.loli.catcatdmdata.entity.CatDanMu
import monster.loli.catcatdmdata.repository.CatDanMuRepository
import monster.loli.catcatdmdata.service.CatDanMuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class CatDanMuServiceImpl: CatDanMuService {
    @Autowired
    lateinit var catDanMuRepository: CatDanMuRepository
    @Autowired
    lateinit var mongoTemplate: MongoTemplate
    override fun listDanMu(clientId: String, roomId: Long?, page: Long, size: Long): Page<CatDanMu?>? {
        val catDanMu = CatDanMu()
        catDanMu.clientId = clientId
        if (roomId != null) {
            catDanMu.roomId = roomId
        }
       val query:ExampleMatcher = ExampleMatcher.matching()
           .withIgnorePaths("userid","uuid","nickname","avatar","live_level","xz_level","xz_name","danmu","time","use_state","type","sessionId")
           .withIgnoreCase(true)
           .withMatcher("sender", ExampleMatcher.GenericPropertyMatchers.contains())
           .withIgnoreNullValues();
        val example:Example<CatDanMu> = Example.of(catDanMu,query)
        return catDanMuRepository.findAll(example, PageRequest.of(page.toInt(), size.toInt())
        )
    }

    override fun addDanMu(catDanMu: CatDanMu){
         mongoTemplate.insert(catDanMu)
    }
}