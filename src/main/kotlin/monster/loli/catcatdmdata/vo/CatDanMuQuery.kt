package monster.loli.catcatdmdata.vo

data class CatDanMuQuery(
        var startTime: Long? = null,
        var endTime: Long? = null,
        var clientId: String? = "",
        var roomId: Long? = null,
        var page: Long? = 1,
        var size: Long? = 10
)
