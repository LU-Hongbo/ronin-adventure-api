package ronin.adventure.controller.request

import ronin.adventure.entity.Blog

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
