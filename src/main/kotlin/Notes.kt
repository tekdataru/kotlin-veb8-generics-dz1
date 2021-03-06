import kotlin.math.max

class Notes {
    private var notes = mutableListOf<Note>()
    private var comments = mutableListOf<Comment>()

    fun add(text:String):Int{
        var i = -1
        for (note in notes){
            i = max(i, note.id)
        }

        val note:Note = Note(i+1, text)
        notes += note

        return note.id
    }

    fun edit(noteId:Int, text: String):Int{
        var ind:Int = -1
        for (note in notes){
            ind++
            if (note.id == noteId){
                val newNote = Note(id = note.id, text = text)
                notes[ind] = newNote
                return 1
            }
        }

        return 0
    }

    fun delete(noteId:Int):Int{
        var wasDeleted = false

        var ind:Int = -1
        for (note in notes){
            ind++
            if (note.id == noteId){
                //notes.removeAt(ind)
                notes.remove(note)
                wasDeleted = true
                break
            }
        }

        ind = - (comments.size)
        while (true){
            ind ++
            if (ind > 0) {break}


            if (comments[-ind].postId == noteId){
                comments.removeAt(-ind)
            }
        }

        if (wasDeleted) {
            return 1
        }

        return 0

    }

    fun createComment(noteId: Int, message:String):Int {
        var newCommentId = -1
        for (comment in comments){
            newCommentId = max(newCommentId, comment.id)
        }

        newCommentId++

        comments += Comment(id = newCommentId, postId = noteId, text = message)
        return newCommentId

    }

    fun editComment(commentId: Int, message:String):Int {
        var ind = -1
        for (comment in comments){
            ind++
            if (comment.id == commentId) {
                if (comment.deleted) throw AttemptToEditDeletedCommentException()

                comments[ind] = Comment(id = comment.id, postId = comment.postId, text = message)
                return 1
            }
        }

        return 0

    }

    fun deleteComment(commentId: Int):Int {

        for (comment in comments){
            if (comment.id == commentId) {
                //comments.remove(comment)
                comment.deleted = true
                return 1
            }
        }

        return 0

    }

    fun undeleteComment(commentId: Int):Int {

        for (comment in comments){
            if (comment.id == commentId) {
                //comments.remove(comment)
                comment.deleted = false
                return 1
            }
        }

        return 0

    }

    fun printAllNotes(){
        println("========== ???????????????? ?????? ?????????????? + ==========")

        for (note in notes){
            println(note)
            /*for (att in post.attachments){
                println("????????????????: " + att.type + " - " + att.value)
            }
            for (comment in comments){
                if (post.id == comment.postId){
                    println("??????????????????????: " + comment.text + " (comment id=${comment.id})")
                }
            }*/
            for (comment in comments){
                if (comment.deleted) continue

                if (note.id == comment.postId){
                    println("    " + comment)
                }
            }
        }

        println("========== ???????????????? ?????? ?????????????? - ==========")
    }
}

