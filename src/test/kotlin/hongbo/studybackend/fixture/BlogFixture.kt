package hongbo.studybackend.fixture

import hongbo.studybackend.controller.request.BlogCreateRequest
import hongbo.studybackend.entity.Blog

object BlogFixture {

    val createRequest = BlogCreateRequest(
        name = "TWKS"
    )

    val blog = Blog(
        id = 1,
        name = "TWKS"
    )
}
