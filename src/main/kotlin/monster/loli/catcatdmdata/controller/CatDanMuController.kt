package monster.loli.catcatdmdata.controller

import monster.loli.catcatdmdata.entity.CatDanMu
import monster.loli.catcatdmdata.service.CatDanMuService
import monster.loli.catcatdmdata.utils.CatCatUtils
import monster.loli.catcatdmdata.vo.CatDanMuQuery
import monster.loli.catcatdmdata.vo.CatPage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("dm")
class CatDanMuController {
    @Autowired
    lateinit var danMuService: CatDanMuService;

    @RequestMapping("listDanMu")
    fun listDanMu(clientId: String,@RequestParam(required = false) roomId: Long?,page: Long,size: Long): Page<CatDanMu?>? {
        if(CatCatUtils.checkClientId(clientId)){
            return   danMuService.listDanMu(clientId,roomId,page,size)
        }
        return null
    }
    @RequestMapping("addDanMu")
    fun addDanMu(@RequestBody catDanMu: CatDanMu,clientId: String,roomId: Long): String {
        //TODO 检查有效性
        if(CatCatUtils.checkClientId(clientId)){
            catDanMu.clientId = clientId
            danMuService.addDanMu(catDanMu)
        }

        return "added"
    }
    @RequestMapping("mapDanMu")
    fun mapDanMu(@RequestBody catDanMuQuery: CatDanMuQuery): CatPage<List<CatDanMu?>?> {
        return danMuService.mapDanMu(catDanMuQuery)
    }
}