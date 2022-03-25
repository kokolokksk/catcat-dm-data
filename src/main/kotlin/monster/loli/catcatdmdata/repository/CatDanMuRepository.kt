package monster.loli.catcatdmdata.repository

import monster.loli.catcatdmdata.entity.CatDanMu
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.Repository
@org.springframework.stereotype.Repository
interface CatDanMuRepository :Repository<CatDanMu?,String?> {
    fun findAll(pageable: Pageable?): Page<CatDanMu?>?
}