class PostNotFoundException:RuntimeException("Post not found") {
}

class AttemptToEditDeletedCommentException:RuntimeException("Attempt to edit deleted comment") {
}