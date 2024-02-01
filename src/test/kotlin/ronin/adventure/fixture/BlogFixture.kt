package ronin.adventure.fixture

import ronin.adventure.controller.request.BlogCreateRequest
import ronin.adventure.controller.request.BlogUpdateRequest
import ronin.adventure.entity.Blog

object BlogFixture {
    val blog =
        Blog(
            id = 1,
            name = "TWKS",
        )

    fun generate(
        id: Long = 1,
        name: String = "TWKS",
    ) = Blog(id, name)

    val createRequest =
        BlogCreateRequest(
            name = "TWKS",
        )

    val updateRequest =
        BlogUpdateRequest(
            id = 1,
            name = "AAPL",
        )
}
