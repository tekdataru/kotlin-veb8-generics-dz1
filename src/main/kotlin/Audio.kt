class Audio (
    val id:Int,
    val album_id:Int = 0,
    val owner_id:Int = 0,
    val user_id:Int = 0,
    val trackName:String
) {
    override fun toString():String{
        return "(id $id, $trackName)"
    }
}