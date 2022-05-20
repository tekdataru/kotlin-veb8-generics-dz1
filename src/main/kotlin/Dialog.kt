class Dialog(
    val id: Int,
    val userIds:MutableList<Int>,
    val messages:MutableList<Message> = mutableListOf<Message>()
) {
    fun add(MessageId:Int, userIdAuthor:Int, messageString: String) {
        for (message in messages){
            message.viewed = true
        }

        messages.add(Message(MessageId, userIdAuthor, id, messageString))
    }

    fun add(message:Message){
        for (message in messages){
            message.viewed = true
        }

        messages.add(message)
    }

    fun remove(messageId:Int){
        val messagesFiltered = messages.filter { it.id == messageId }

        for (message in messagesFiltered) {
            messages.remove(message)
        }
    }

    fun edit(messageId:Int, newMessageText:String){
        val messagesFiltered = messages.filter { it.id == messageId }

        for (message in messagesFiltered) {
            message.text = newMessageText
        }
    }

}