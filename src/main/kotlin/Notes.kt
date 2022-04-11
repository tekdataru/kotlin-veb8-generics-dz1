import kotlin.math.max

class Notes {
    var notes:List<Note> = emptyList()

    fun add(text:String){
        var i = -1
        for (note in notes){
            i = max(i, note.id)
        }

        val note:Note = Note(i+1, text)
        notes += note
    }

    fun edit(noteId:Int, text: String){
        var ind:Int = -1
        for (note in notes){
            ind++
            if (note.id == noteId){
                val newNote = Note(id = note.id, text = text)
                notes[0] = newNote
            }
        }
    }

    fun printAllNotes(){
        println("========== ПЕЧАТАЕМ ВСЕ ЗАМЕТКИ + ==========")

        for (note in notes){
            println(note)
            /*for (att in post.attachments){
                println("Вложение: " + att.type + " - " + att.value)
            }
            for (comment in comments){
                if (post.id == comment.postId){
                    println("Комментарий: " + comment.text + " (comment id=${comment.id})")
                }
            }*/
        }

        println("========== ПЕЧАТАЕМ ВСЕ ЗАМЕТКИ - ==========")
    }
}

