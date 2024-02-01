package ronin.adventure.controller.response

import ronin.adventure.entity.Blog

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
