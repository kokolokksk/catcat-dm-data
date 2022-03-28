package monster.loli.catcatdmdata.controller

import jakarta.servlet.http.HttpServletRequest
import monster.loli.catcatdmdata.entity.CatClient
import monster.loli.catcatdmdata.service.CatClientService
import monster.loli.catcatdmdata.utils.CatCatUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("client")
class ClientController {
    @Autowired
    lateinit var catClientService: CatClientService
    @Value("\${env.config.client_length}")
    lateinit var index:String
    @RequestMapping("generateClientId")
    fun generateClientId(request:HttpServletRequest): String? {
        val cc: CatClient = CatClient()
        cc.clientId = CatCatUtils.generateRandomString(index.toInt(),false)
        cc.ts = System.currentTimeMillis()
        try{
            cc.ip = request.getHeader("x-forwarded-for")
            cc.userAgent = request.getHeader("user-agent")
        }catch (e:Exception){
            // e.printStackTrace()
        }
        catClientService.addClientId(cc)
        return cc.clientId
    }
}