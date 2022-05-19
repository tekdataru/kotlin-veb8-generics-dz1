class Dialogs {
    var dialogs: MutableList<Dialog> = mutableListOf<Dialog>()


    fun add(dialog: Dialog) {
        for (dialogIn in dialogs) {
            if (dialog.id == dialogIn.id) return
        }

        dialogs.add(dialog)
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
                println("Ид автора: ${message.userIdAuthor}. Сообщение: ${message.text}")
            }
        }

        println("============= ПЕЧАТАЕМ ВСЕ ДИАЛОГИ- ============")
    }
}