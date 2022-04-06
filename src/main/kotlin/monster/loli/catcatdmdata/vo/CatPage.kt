package monster.loli.catcatdmdata.vo

data class  Pager(
    var total: Long,
    var page: Int,
    var size: Int,
)

data class CatPage<T>(
        var pager: Pager,
        var data: T
)
