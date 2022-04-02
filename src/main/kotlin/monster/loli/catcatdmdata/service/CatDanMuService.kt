package monster.loli.catcatdmdata.service

import monster.loli.catcatdmdata.entity.CatDanMu
import org.springframework.data.domain.Page

interface CatDanMuService {
    fun listDanMu(clientId: String,roomId: Long,page: Long,size: Long): Page<CatDanMu?>?
    fun addDanMu(catDanMu: CatDanMu)
}