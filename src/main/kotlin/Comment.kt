class Comment (
    val id:Int,
    val postId:Int,//id поста, для которого комментарий
    val fromId:Int = 0,//Идентификатор автора комментария.
    val date:Int = 0,//Дата создания комментария в формате Unixtime.
    val text:String,
    val donut:Any? = null,/*Информация о VK Donut. Объект со следующими полями:
                    is_don (boolean) — является ли комментатор подписчиком VK Donut.
                    placeholder (string) — заглушка для пользователей, которые не оформили подписку VK Donut.*/
    val replyToUser:Int = 0,//Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
    val replyToComment:Int = 0,//Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
    val attachments:Array<Attachment> = emptyArray() ,//Медиавложения комментария (фотографии, ссылки и т.п.). Описание массива attachments находится на отдельной странице.
    val parentsStack:Any? = null,//Массив идентификаторов родительских комментариев.
    val thread:Any? = null/*Информация о вложенной ветке комментариев, объект с полями:
                    count (integer) — количество комментариев в ветке.
                    items (array) — массив объектов комментариев к записи (только для метода wall.getComments).
                    can_post (boolean) – может ли текущий пользователь оставлять комментарии в этой ветке.
                    show_reply_button (boolean) – нужно ли отображать кнопку «ответить» в ветке.
                    groups_can_post (boolean) – могут ли сообщества оставлять комментарии в ветке.*/
) {
    override fun toString():String{
        return "(cmnt id $id, $text)"
    }
}