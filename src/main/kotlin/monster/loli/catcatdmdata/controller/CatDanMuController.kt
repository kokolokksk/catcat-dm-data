package monster.loli.catcatdmdata.controller

import monster.loli.catcatdmdata.entity.CatDanMu
import monster.loli.catcatdmdata.service.CatDanMuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("dm")
class CatDanMuController {
    @Autowired
    lateinit var danMuService: CatDanMuService;

    @RequestMapping("listDanMu")
    fun listDanMu(clientId: String,roomId: Long): Page<CatDanMu?>? {
        return danMuService.listDanMu("1",1)
    }
    @RequestMapping("addDanMu")
    fun addDanMu(@RequestBody catDanMu: CatDanMu): String {
        danMuService.addDanMu(catDanMu)
        return ""
    }
}