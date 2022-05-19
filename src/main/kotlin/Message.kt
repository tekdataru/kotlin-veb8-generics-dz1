class Message(
    val userIdAuthor: Int,
    val dialogId: Int,
    val text:String
) {

    override fun toString():String{
        return "Автор ид: $userIdAuthor, диалог ид:$dialogId. Сообщение: $text"
    }

}