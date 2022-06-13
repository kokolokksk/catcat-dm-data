package monster.loli.catcatdmdata.utils

import com.google.gson.Gson
import monster.loli.catcatdmdata.entity.BiliBiliUserInfo
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


object CatCatUtils {

    fun generateRandomString(i: Int, b: Boolean): String {
        var index = 0
        val charArray = arrayOf('a','b','c','d','e','f','g','h','i','j','k','l','m','n','1','2','9')
        val stringBuilder = StringBuilder()
        while (index<i){
            val randomIndex = (0..16).random()
            stringBuilder.append( (charArray[randomIndex]))
            index++
        }
        return stringBuilder.toString()
    }

   fun checkClientId(clientId:String):Boolean{
        var checkResult = true
        val charArray = arrayOf('o','p','q','r','s','t','u','v','w','x','y','z','3','4','5','6','7','8','0')
        val clientArray =clientId.toCharArray()
        clientArray.forEach {
            if(charArray.contains(it))
                checkResult = false
        }

        return checkResult
    }


   fun downFile(url:String):String{
       var path = ""
       val client= OkHttpClient();
       val request : Request =  Request.Builder()
           .url(url)
           .addHeader("referer","https://www.bilibili.com/")
           .build();
       var input : InputStream? = null
       var buf = ByteArray(2048)
       var  len = 0
       var fos: FileOutputStream? = null
       try{
           val response: Response = client . newCall (request).execute()
           // logger.info(response.body?.string() ?: "");


           val dir = File(System.getProperty("user.dir")+"/static/upload/")
            if(!dir.exists()){
                dir.mkdirs()
            }
           val file = File(dir,url.split("/").last())
            path = file.absolutePath
           input = response.body?.byteStream()
           val total = response.body?.contentLength();
           fos = FileOutputStream(file)
           var sum =0
           while (len != -1){
               len = input?.read(buf)!!
               fos.write(buf,0,len)
               sum+=len
           }
           fos.flush()
       }catch (e:Exception){
           e.printStackTrace()
       }finally {
           try{
               if(input != null){
                   input.close()
               }
               if(fos !=null){
                   fos.close()
               }
           }catch (e:Exception){
               e.printStackTrace()
           }
       }
       return path
   }
    @JvmStatic
    fun main(args: Array<String>) {
      /*  while (true){
            val s = generateRandomString(16,false)
            println(s)
        }
       val rs =  checkClientId("2ada")
        println(rs)*/
        downFile("https://i2.hdslb.com/bfs/face/2dacd5b4e08d872098a79c14be6caff6df829162.jpg")
    }
}
