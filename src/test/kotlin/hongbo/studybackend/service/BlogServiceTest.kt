package hongbo.studybackend.service

import hongbo.studybackend.fixture.BlogFixture
import hongbo.studybackend.repository.BlogRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
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

    private val blog = BlogFixture.blog

    @Nested
    inner class WhenQuery {

        @Test
        fun `should return main blog`() {
            `when`(repository.getReferenceById(any())).thenReturn(blog)

            val result = service.getMainBlog(blog.id)

            assertEquals(blog.name, result.name)
        }
    }

    @Nested
    inner class WhenCreate {

        @Test
        fun `should create blog successfully`() {
            `when`(repository.save(any())).thenReturn(blog)

            val result = service.create(BlogFixture.createRequest)

            assertEquals(blog.name, result.name)
        }
    }
}
