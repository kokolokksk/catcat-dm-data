package monster.loli.catcatdmdata.controller

import monster.loli.catcatdmdata.entity.CatDanMu
import monster.loli.catcatdmdata.service.CatDanMuService
import monster.loli.catcatdmdata.utils.CatCatUtils
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
        if(CatCatUtils.checkClientId(clientId)){
            return   danMuService.listDanMu("1",1)
        }
        return null
    }
    @RequestMapping("addDanMu")
    fun addDanMu(@RequestBody catDanMu: CatDanMu,clientId: String,roomId: Long): String {
        //TODO 检查有效性
        if(CatCatUtils.checkClientId(clientId)){
            danMuService.addDanMu(catDanMu)
        }

        return "added"
    }
}