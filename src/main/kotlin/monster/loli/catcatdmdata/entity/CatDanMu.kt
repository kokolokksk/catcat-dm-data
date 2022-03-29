package monster.loli.catcatdmdata.entity

import com.fasterxml.jackson.annotation.JsonAlias
import com.google.gson.annotations.SerializedName
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.annotation.AliasFor
import org.springframework.data.mongodb.core.mapping.Field

data class CatDanMu(
    var userid:String = "",
    var uuid: Long? = null,
    var nickname:String="",
    var avatar:String ="",
    var live_level:String ="",
    var xz_Level:String = "",
    var xz_name:String = "",
    var danmu:String = "",
    var time:Long = 0,
    var use_state:Long = 0,
    var type:Int = 1,
    var clientId:String = "",
    var roomId:Long = 0,
    var sessionId:String = ""
)
