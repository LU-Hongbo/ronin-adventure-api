package hongbo.studybackend.controller.response

import hongbo.studybackend.entity.Blog

data class BlogResponse(
    val id: Long,
    val name: String,
) {
    companion object {
        fun Blog.toResponse() =
            BlogResponse(
                id = id,
                name = name,
            )
    }
}
