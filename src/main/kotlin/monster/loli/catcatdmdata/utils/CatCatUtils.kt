package monster.loli.catcatdmdata.utils



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

    @JvmStatic
    fun main(args: Array<String>) {
      /*  while (true){
            val s = generateRandomString(16,false)
            println(s)
        }
       val rs =  checkClientId("2ada")
        println(rs)*/
    }
}
