package hongbo.studybackend.fixture

import hongbo.studybackend.controller.request.BlogCreateRequest
import hongbo.studybackend.controller.request.BlogUpdateRequest
import hongbo.studybackend.entity.Blog

object BlogFixture {

    val blog = Blog(
        id = 1,
        name = "TWKS"
    )

    fun generate(
        id: Long = 1,
        name: String = "TWKS"
    ) = Blog(id, name)

    val createRequest = BlogCreateRequest(
        name = "TWKS"
    )

    val updateRequest = BlogUpdateRequest(
        id = 1,
        name = "AAPL"
    )
}
