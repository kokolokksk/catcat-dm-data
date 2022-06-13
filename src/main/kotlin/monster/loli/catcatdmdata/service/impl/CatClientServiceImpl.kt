package monster.loli.catcatdmdata.service.impl

import com.google.gson.Gson
import monster.loli.catcatdmdata.entity.BiliBiliUserInfo
import monster.loli.catcatdmdata.entity.BilibiliUser
import monster.loli.catcatdmdata.entity.CatClient
import monster.loli.catcatdmdata.service.CatClientService
import monster.loli.catcatdmdata.utils.CatCatUtils
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.insert
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import java.io.File
import java.util.Collections

@Service
class CatClientServiceImpl: CatClientService {
    @Autowired
    lateinit var mongoTemplate: MongoTemplate


    override fun addClientId(catClient: CatClient){
         mongoTemplate.insert(catClient)
    }

    override fun getUserInfo(uid: String): LinkedHashMap<String, Any> {
        var faceMap : LinkedHashMap<String,Any> = LinkedHashMap()
        //todo 查询本地数据库
        var query: Query = Query.query(Criteria.where("uid").`is`(uid.toLong()))
        val l:List<BilibiliUser> = mongoTemplate.find(query, BilibiliUser::class.java)
        if(l.isEmpty()){
            //无数据 查询
            val data = queryUserInfoFromBilibili(uid.toLong()) ?: return Collections.EMPTY_MAP as LinkedHashMap<String, Any>
            //save to
            val bilibiliUser = BilibiliUser()
            bilibiliUser.uid = data.data?.info?.uid ?: 0;
            bilibiliUser.face = data.data?.info?.face ?:"";
            bilibiliUser.roomId = (data.data?.room_id ?: 0).toLong();
            bilibiliUser.gender = data.data?.info?.gender?:0;
            bilibiliUser.followerNum = "0," + (data.data?.follower_num?:"0");
            bilibiliUser.uname = data.data?.info?.uname?:"";
            mongoTemplate.insert(bilibiliUser)
            val path = CatCatUtils.downFile(bilibiliUser.face);
            faceMap.put("face",bilibiliUser.face.split("/").last())
            
        } else {
            val dir = File(System.getProperty("user.dir")+"/static/upload/")
            val file = File(dir,l[0].face)
            if(!file.exists()){
                CatCatUtils.downFile(l[0].face);
            }
            faceMap.put("face",l[0].face.split("/").last())
        }
        return  faceMap
    }

    private fun queryUserInfoFromBilibili(uid: Long): BiliBiliUserInfo? {
        var data : BiliBiliUserInfo? =null;
        val client: OkHttpClient = OkHttpClient();
        val url = "https://api.live.bilibili.com/live_user/v1/Master/info?uid=$uid"
        val request : Request =  Request.Builder()
            .url(url)
            .addHeader("referer","https://www.bilibili.com/")
            .build();
        var r : LinkedHashMap<String,Any> = LinkedHashMap()
        try{
            val response: Response = client . newCall (request).execute()
            // logger.info(response.body?.string() ?: "");
            val g: Gson = Gson()
            data = g.fromJson(response.body?.string(), BiliBiliUserInfo::class.java)
            data.data?.info?.face?.let { r.put("face", it) }
        }catch (e:Exception){
            e.printStackTrace()
        }
       return data;
    }


}