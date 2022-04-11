class AttachmentAudio(audio: Audio):Attachment {
    override val type: String = "audio"
    override val value: Audio? = audio
}