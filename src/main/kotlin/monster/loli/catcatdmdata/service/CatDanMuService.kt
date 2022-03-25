package monster.loli.catcatdmdata.service

import monster.loli.catcatdmdata.entity.CatDanMu

interface CatDanMuService {
    fun listDanMu(clientId: String,roomId: Long):ArrayList<LinkedHashMap<String,Any>>
    fun addDanMu(catDanMu: CatDanMu)
}