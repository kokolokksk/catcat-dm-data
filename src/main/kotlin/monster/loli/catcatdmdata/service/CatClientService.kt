package monster.loli.catcatdmdata.service

import monster.loli.catcatdmdata.entity.CatClient

interface CatClientService {

    fun addClientId(catClient: CatClient)
    fun getUserInfo(uid: String): LinkedHashMap<String, Any>
}