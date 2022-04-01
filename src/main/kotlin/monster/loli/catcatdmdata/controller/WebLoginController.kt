package monster.loli.catcatdmdata.controller

import monster.loli.catcatdmdata.service.WebLoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("web")
class WebLoginController {
    @Autowired
    lateinit var webLoginService: WebLoginService
    @RequestMapping("login/{clientId}")
    fun loginWeb(@PathVariable("clientId") clientId:String ): LinkedHashMap<String, Any> {
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