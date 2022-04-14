import org.junit.Assert.*
import org.junit.Test

class NotesTest {
    @Test(expected = AttemptToEditDeletedCommentException::class)
    fun shouldThrowAttemptToEditDeletedCommentException() {
        //var note = Note(0, "Заметка 0")
        var comment = Comment(0,0, text = "Комент")

        val notes = Notes()
        val noteId = notes.add("Заметка")
        val commentId = notes.createComment(noteId, "Коммент")

        notes.deleteComment(commentId)
        notes.editComment(commentId, "asdf")
    }


    @Test
    fun add() {
        val notes = Notes()
        notes.add("0")
        notes.add("1")
        notes.add("2")


        assertEquals(3, notes.add("3"))

        notes.edit(0, "Первая заметка редакция 1")
        notes.createComment(0, "Первый коммент к 1 заметке")
        notes.createComment(0, "Второй коммент к 1 заметке")
        notes.add("Вторая заметка")
        notes.edit(1,"Вторая заметка ред. 1")
        notes.createComment(1, "Первый коммент к 2 заметке")
        notes.add("Третья заметка")
        notes.createComment(2, "Коммент к 3 заметке")
        notes.deleteComment(3)
        notes.undeleteComment(3)
        notes.editComment(3, "Редактируем удаленный/восстановленный комментарий")
        notes.createComment(2, "Второй коммент к 3 заметке")
        notes.editComment(4, "Второй коммент к 3 заметке ред 1")


        assertEquals(0, notes.delete(3333))
    }

    @Test
    fun edit() {
        val notes = Notes()
        notes.add("0")
        val res = notes.edit(0, "Первая заметка редакция 1")

        assertEquals(1, res)
    }

    @Test
    fun `edit unexist`() {
        val notes = Notes()
        notes.add("0")
        val res = notes.edit(11111, "Первая заметка редакция 1")

        assertEquals(0, res)
    }

    @Test
    fun delete() {
        val notes = Notes()
        notes.add("0")
        val res = notes.delete(0)

        assertEquals(1, res)
    }

    @Test
    fun `delete unexist`() {
        val notes = Notes()
        notes.add("0")
        val res = notes.delete(5555)

        assertEquals(0, res)
    }

    @Test
    fun createComment() {
        val notes = Notes()
        notes.add("0")


        val res = notes.createComment(0, "Первый коммент к 1 заметке")

        if (res == -1) {
            assertEquals(1, 0)
        } else {
            assertEquals(0, 0)
        }
    }

    @Test
    fun editComment() {
        val notes = Notes()
        notes.add("0")
        val res0 = notes.createComment(0," asdf")
        val res = notes.editComment(res0, "adfs")

        assertEquals(1, res)
    }

    @Test
    fun `editComment unexist`() {
        val notes = Notes()
        notes.add("0")
        val res0 = notes.createComment(0," asdf")
        val res = notes.editComment(999, "adfs")

        assertEquals(0, res)
    }

    @Test
    fun deleteComment() {
        val notes = Notes()
        notes.add("0")
        val res0 = notes.createComment(0," asdf")
        val res = notes.deleteComment(0)

        assertEquals(1, res)
    }

    @Test
    fun `deleteComment unexist`() {
        val notes = Notes()
        notes.add("0")
        val res0 = notes.createComment(0," asdf")
        val res = notes.deleteComment(9999)

        assertEquals(0, res)
    }

    @Test
    fun undeleteComment() {
        val notes = Notes()
        notes.add("0")
        val res0 = notes.createComment(0," asdf")
        notes.deleteComment(0)
        val res = notes.undeleteComment(0)

        assertEquals(1, res)
    }

    @Test
    fun `undeleteComment unexist`() {
        val notes = Notes()
        notes.add("0")
        val res0 = notes.createComment(0," asdf")
        val res = notes.undeleteComment(9999)

        assertEquals(0, res)
    }


}