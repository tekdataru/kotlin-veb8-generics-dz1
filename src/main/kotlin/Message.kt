class Message(
    val id:Int,
    val userIdAuthor: Int,
    val dialogId: Int,
    var text:String,
    var viewed:Boolean = false
) {

    override fun toString():String{
        return "Автор ид: $userIdAuthor, диалог ид:$dialogId. Сообщение: $text"
    }

}