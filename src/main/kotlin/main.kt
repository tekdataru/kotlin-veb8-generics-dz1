fun main() {

    val post = Post(id = 1, text = "Текст 1")
    var post2 = Post(id = 2, text = "Текст 2")
    val post3 = Post(id = 1, text = "Текст 3")

    var att:Attachment = AttachmentAudio(Audio(id=1, trackName = "Песня 1"))
    post2.addAttachment(att)

    att = AttachmentVideo(Video(id=1, title = "Видео 1"))
    post2.addAttachment(att)

    att = AttachmentVideo(Video(id=2, title = "Видео 2"))
    post2.addAttachment(att)

    post3.addAttachment(att)

    post3.addAttachment(AttachmentPhoto(Photo(id=2, title = "Фото 2")))
    post3.addAttachment(AttachmentNote(Note(id=2, text = "Заметка 2")))
    post2.addAttachment(AttachmentNote(Note(id=2, text = "Заметка 222")))

    val ws = WallService()

    ws.add(post)
    ws.add(post2)
    ws.add(post3)
    ws.update(post3)

    var comment = Comment(id = 1, postId = 1, text = "Comment 1 to post 1")
    ws.createComment(comment)

   //comment = Comment(id = 2, postId = 999, text = "Comment for non exist post")
   // ws.createComment(comment)

    ws.printAllPosts()

    //========== Работаем с заметками+ ==========

    val notes = Notes()
    notes.add("Первая заметка")
    notes.edit(0, "Первая заметка редакция 1")
    notes.createComment(0, "Первый коммент к 1 заметке")
    notes.createComment(0, "Второй коммент к 1 заметке")
    notes.add("Вторая заметка")
    notes.edit(1,"Вторая заметка ред. 1")
    notes.createComment(1, "Первый коммент к 2 заметке")
    notes.add("Третья заметка")
    notes.createComment(2, "Коммент к 3 заметке")
    notes.deleteComment(3)
    notes.createComment(2, "Второй коммент к 3 заметке")
    notes.editComment(4, "Второй коммент к 3 заметке ред 1")
    notes.delete(1)

    notes.printAllNotes()



    //========== Работаем с заметками- ==========
}