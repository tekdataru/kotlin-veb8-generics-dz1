class Dialog(
    val id: Int,
    val userIds:MutableList<Int>,
    val messages:MutableList<Message> = mutableListOf<Message>()
) {
    fun add(userIdAuthor:Int, messageString: String) {
        messages.add(Message(userIdAuthor, id, messageString))
    }

    fun add(message:Message){
        messages.add(message)
    }

}