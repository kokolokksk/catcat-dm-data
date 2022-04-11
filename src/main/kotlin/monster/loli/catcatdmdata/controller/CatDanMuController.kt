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
import java.util.Calendar
import java.util.Date

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
    fun mapDanMu(@RequestBody catDanMuQuery: CatDanMuQuery): CatPage<List<CatDanMu?>?>? {
        if(catDanMuQuery.clientId==null) return null
        catDanMuQuery.clientId?.let { if(!CatCatUtils.checkClientId(it)) return null }
        return danMuService.mapDanMu(catDanMuQuery)
    }
    @RequestMapping("statisticalDanMu")
    fun statisticalDanMu(clientId: String,startTime: Long?,endTime: Long?,abscissa: String?): Map<String,Long>? {
        if(!CatCatUtils.checkClientId(clientId)) return null
        val cal = Calendar.getInstance()
        var ts: Long = 0
        var te: Long = 0
        if(endTime!=null){
            te = endTime
        }else{
            cal.set(cal[Calendar.YEAR],cal[Calendar.MONTH],cal[Calendar.DATE],23,59,59)
            te = cal.time.time / 1000
        }
        if(startTime!=null){
            ts = startTime
        }else{
            cal.set(cal[Calendar.YEAR],cal[Calendar.MONTH],1,0,0,0)
            ts = cal.time.time / 1000
        }
        val x: String = if(abscissa!=null) abscissa else "date"
        return danMuService.statisticalDanMu(ts,te,x,clientId)
    }
}