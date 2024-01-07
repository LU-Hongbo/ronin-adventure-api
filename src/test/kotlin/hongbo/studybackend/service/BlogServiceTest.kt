package hongbo.studybackend.service

import hongbo.studybackend.fixture.BlogFixture
import hongbo.studybackend.repository.BlogRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.any
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@ExtendWith(MockitoExtension::class)
@SpringBootTest
class BlogServiceTest {

    @Autowired
    private lateinit var service: BlogService

    @MockBean
    private lateinit var repository: BlogRepository

    @Test
    fun `should return main blog`() {
        `when`(repository.getReferenceById(any())).thenReturn(BlogFixture.blog)

        val result = service.getMainBlog()

        assertEquals("TWKS", result.name)
    }
}