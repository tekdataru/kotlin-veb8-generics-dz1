class WallService {
    private var posts:Array<Post> = emptyArray()
    private var comments = emptyArray<Comment>()

    fun add(post: Post): Post {
        for (p in posts){
            if (p.id == post.id) return p
        }

        posts += post


        return posts.last()
    }

    fun update(post: Post): Boolean {
        var ind = -1
        for (p in posts){
            ind++
            if (p.id == post.id) {
                val np = post.copy(id = post.id, text = post.text)
                posts.set(ind, np)
                return true
            }
        }

        return false
    }

    fun createComment(comment: Comment) {
        for (post in posts){
            if (post.id == comment.postId) {
                comments += comment
                return
            }
        }

        throw PostNotFoundException()
    }

    fun printAllPosts(){

        println("========== ПЕЧАТАЕМ ВСЕ ПОСТЫ + ==========")

        for (post in posts){
            println("" + post.id + " - " + post.text)
            for (att in post.attachments){
                println("Вложение: " + att.type + " - " + att.value)
            }
            for (comment in comments){
                if (post.id == comment.postId){
                    println("Комментарий: " + comment.text + " (comment id=${comment.id})")
                }
            }
        }

        println("========== ПЕЧАТАЕМ ВСЕ ПОСТЫ - ==========")

    }
}