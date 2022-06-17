package monster.loli.catcatdmdata.entity



data class BilibiliUser(
    var uid:Long = 0,
    var uname: String = "",
    var face:String="",
    var officialVerify:String ="",
    var gender:Int =-1,
    var followerNum:String = "0",
    var roomId:Long = 0,
    var medalName:String = ""
)
