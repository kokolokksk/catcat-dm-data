package monster.loli.catcatdmdata.repository

import monster.loli.catcatdmdata.entity.CatDanMu
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.Repository
interface CatDanMuRepository : MongoRepository<CatDanMu?, Int?> {


}