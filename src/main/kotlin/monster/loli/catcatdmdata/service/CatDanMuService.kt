package monster.loli.catcatdmdata.service

import monster.loli.catcatdmdata.entity.CatDanMu
import monster.loli.catcatdmdata.vo.CatDanMuQuery
import monster.loli.catcatdmdata.vo.CatPage
import org.springframework.data.domain.Page

interface CatDanMuService {
    fun listDanMu(clientId: String,roomId: Long?,page: Long,size: Long): Page<CatDanMu?>?
    fun addDanMu(catDanMu: CatDanMu)
    fun mapDanMu(catDanMuQuery: CatDanMuQuery): CatPage<List<CatDanMu?>?>
    fun statisticalDanMu(ts: Long,te: Long,x: String,clientId: String): Map<String,Long>?
}