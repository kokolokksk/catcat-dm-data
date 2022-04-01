package monster.loli.catcatdmdata.service

import monster.loli.catcatdmdata.entity.CatClient
import monster.loli.catcatdmdata.entity.CatDanMu
import org.springframework.data.domain.Page

interface WebLoginService {
    fun loginWeb(clientId: String): MutableList<CatClient>
}