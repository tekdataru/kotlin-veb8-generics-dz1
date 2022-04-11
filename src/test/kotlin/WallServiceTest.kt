import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun `add after add id not 0`() {
        val p1 = Post(id = 1, text = "text1")
        val p2 = Post(id = 2, text = "text2")
        val p3 = Post(id = 1, text = "text3")

        val ws = WallService()
        val pp = ws.add(p1)

        assertEquals(false, pp.id == 0)
    }

    @Test
    fun `update when id exists`() {
        val p1 = Post(id = 1, text = "text1")
        val p2 = Post(id = 2, text = "text2")
        val p3 = Post(id = 1, text = "text3")

        val ws = WallService()
        ws.add(p1)



        assertEquals(true ,ws.update(p1))
    }

    @Test
    fun `update when id not exists`() {
        val p1 = Post(id = 1, text = "text1")
        val p2 = Post(id = 2, text = "text2")
        val p3 = Post(id = 1, text = "text3")

        val ws = WallService()
        ws.add(p2)



        assertEquals(false ,ws.update(p1))
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val p1 = Post(id = 1, text = "text1")
        val p2 = Post(id = 2, text = "text2")
        val p3 = Post(id = 1, text = "text3")

        val ws = WallService()

        ws.add(p1)

        val comment = Comment(id = 2, postId = 999, text = "Comment for non exist post")

        ws.createComment(comment)
    }
}