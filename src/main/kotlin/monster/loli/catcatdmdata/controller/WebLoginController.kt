package monster.loli.catcatdmdata.controller

import monster.loli.catcatdmdata.service.WebLoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("web")
class WebLoginController {
    @Autowired
    lateinit var webLoginService: WebLoginService
    @RequestMapping("login")
    fun loginWeb(@RequestBody clientId:String ): LinkedHashMap<String, Any> {
        var dataMap = LinkedHashMap<String,Any>()
        var rs = webLoginService.loginWeb(clientId);
        if(rs.size==0){
            dataMap["login"] = false
        }else{
            dataMap["login"] = true
            dataMap["clientId"] = rs[0].clientId
        }
        return dataMap
    }
}