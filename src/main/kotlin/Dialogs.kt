class Dialogs {
    var dialogs: MutableList<Dialog> = mutableListOf<Dialog>()


    fun add(dialog: Dialog) {

        if (dialogs.filter { it == dialog }.size > 0) return

        dialogs.add(dialog)
    }

    fun remove(dialogId: Int) {

        val dialogsFiltered = dialogs.filter { it.id == dialogId }

        for (dialogIn in dialogsFiltered) {
            dialogs.remove(dialogIn)
        }

    }

    fun removeMessage(messageId:Int){
        for (dialog in dialogs){
            dialog.remove(messageId)
        }
    }

    fun editMessage(messageId:Int, newMessageText:String){
        for (dialog in dialogs){
            dialog.edit(messageId, newMessageText)
        }
    }

    fun pritnAllDialogs() {
        println("============= ПЕЧАТАЕМ ВСЕ ДИАЛОГИ+ ============")

        for (dialog in dialogs) {
            println("Диалог (ид:${dialog.id})")
            var str: String = ""
            for (userId in dialog.userIds) {
                str += "" + userId + ","
            }
            println("Идентификторы участников диалога: $str")

            for (message in dialog.messages) {
                var strViewed = "Непрочитано"

                if (message.viewed) {
                    strViewed = "Прочитано"
                }

                println("Ид автора: ${message.userIdAuthor}. Сообщение: ${message.text} (ид ${message.id}, $strViewed)")
            }
        }

        println("============= ПЕЧАТАЕМ ВСЕ ДИАЛОГИ- ============")
    }
}