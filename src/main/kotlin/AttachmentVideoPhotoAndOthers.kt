//Video+
class AttachmentVideo(video: Video):Attachment {
    override val type: String = "video"
    override val value: Video = video
}

class Video (
    val id:Int,
    val title:String
) {
    override fun toString():String{
        return "(id $id, $title)"
    }
}
//Video-

//Photo+
class AttachmentPhoto(photo: Photo):Attachment {
    override val type: String = "photo"
    override val value: Photo = photo
}

class Photo (
    val id:Int,
    val title:String
) {
    override fun toString():String{
        return "(id $id, $title)"
    }
}
//Photo-

//Note+
class AttachmentNote(note: Note):Attachment {
    override val type: String = "note"
    override val value: Note = note
}

class Note (
    val id:Int,
    val text:String
) {
    override fun toString():String{
        return "Заметка $id: $text"
    }
}
//Note-