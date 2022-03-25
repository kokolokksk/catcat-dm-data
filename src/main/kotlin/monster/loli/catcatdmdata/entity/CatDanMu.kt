package monster.loli.catcatdmdata.entity

data class CatDanMu(
    var userid:String = "",
    var uuid: Long? = null,
    var nickname:String="",
    var avatar:String ="",
    var liveLevel:String ="",
    var xzLevel:String = "",
    var xzName:String = "",
    var danmu:String = "",
    var time:Long = 0,
    var useState:Long = 0,
    var messageType:Int = 1,
    var clientId:String = "",
    var roomId:Long = 0,
    var sessionId:String = ""
)
