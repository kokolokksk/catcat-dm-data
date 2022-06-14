package monster.loli.catcatdmdata.entity

import com.fasterxml.jackson.annotation.JsonAlias
import com.google.gson.annotations.SerializedName
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.annotation.AliasFor
import org.springframework.data.mongodb.core.mapping.Field

data class CatDanMu(
    var uuid: String? = null,
    var type:Int = 0,
    var uid: Long? = null,
    var nickname:String="",
    var content:String = "",
    var price:Long =0,
    var giftName:String ="",
    var giftImg:String = "",
    var timestamp:String = "",
    var giftType:Int = 0,
    var avatarFace:String = "",
    var roomId:Long? = null,
    var sessionId:String = "",
    var clientId:String = ""
)
