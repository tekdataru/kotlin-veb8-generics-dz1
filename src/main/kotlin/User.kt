class User(
    val id: Int,
    val fullName: String
) {
    override fun toString(): String {
        return "User $id, $fullName"
    }
}