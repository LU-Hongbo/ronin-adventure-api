package hongbo.studybackend.controller.request

import hongbo.studybackend.entity.Blog

data class BlogUpdateRequest(
    val id: Long,
    val name: String,
) {
    fun toEntity() =
        Blog(
            id = id,
            name = name,
        )
}
