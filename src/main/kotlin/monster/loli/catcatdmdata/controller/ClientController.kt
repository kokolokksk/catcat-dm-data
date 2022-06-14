package monster.loli.catcatdmdata.controller

import com.google.gson.Gson
import jakarta.servlet.http.HttpServletRequest
import monster.loli.catcatdmdata.entity.BiliBiliUserInfo
import monster.loli.catcatdmdata.entity.CatClient
import monster.loli.catcatdmdata.service.CatClientService
import monster.loli.catcatdmdata.utils.CatCatUtils
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okio.IOException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Collections

@RestController
@RequestMapping("client")
class ClientController {
    val logger:Logger = LoggerFactory.getLogger(this::class.java)
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
            cc.version = request.getHeader("version")
        }catch (e:Exception){
            // e.printStackTrace()
        }
        catClientService.addClientId(cc)
        return cc.clientId
    }
    @RequestMapping("getUserInfo")
    fun getUserInfo(uid:String): Map<String,Any> {
        var r : LinkedHashMap<String,Any> = LinkedHashMap()
        r = catClientService.getUserInfo(uid)
        return r
  }
}