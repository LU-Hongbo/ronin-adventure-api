package hongbo.studybackend.service

import hongbo.studybackend.fixture.BlogFixture
import hongbo.studybackend.repository.BlogRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.Optional

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
        fun `should return blog given existent blog id`() {
            `when`(repository.findById(any())).thenReturn(Optional.of(blog))

            val result = service.getById(blog.id)

            assertEquals(blog.name, result.name)
        }

        @Test
        fun `should throw error given nonexistent blog id`() {
            val nonexistentId = 10L
            `when`(repository.findById(any())).thenReturn(Optional.empty())

            assertThrows<IllegalArgumentException> {
                service.getById(nonexistentId)
            }
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

    @Nested
    inner class WhenUpdate {

        @Test
        fun `should return updated blog given blog with existing id`() {
            val updated = BlogFixture.generate(id = 1, name = "AAPL")
            `when`(repository.findById(any())).thenReturn(Optional.of(blog))
            `when`(repository.save(any())).thenReturn(updated)

            val result = service.update(BlogFixture.updateRequest)

            assertEquals("AAPL", result.name)
        }

        @Test
        fun `should throw error if blog not exist`() {
            val nonexistentId: Long = 10
            `when`(repository.findById(any())).thenReturn(Optional.empty())

            assertThrows<IllegalArgumentException> {
                service.update(BlogFixture.updateRequest.copy(id = nonexistentId))
            }
        }
    }

    @Nested
    inner class WhenDelete {

        @Test
        fun `should return deleted blog given blog with existing id`() {
            `when`(repository.findById(any())).thenReturn(Optional.of(blog))
            doNothing().`when`(repository).deleteById(any())

            service.deleteById(blog.id)

            verify(repository).deleteById(blog.id)
        }

        @Test
        fun `should throw error if blog not exist`() {
            val nonexistentId: Long = 10
            `when`(repository.findById(any())).thenReturn(Optional.empty())

            assertThrows<IllegalArgumentException> {
                service.update(BlogFixture.updateRequest.copy(id = nonexistentId))

                verify(repository, never()).deleteById(blog.id)
            }
        }
    }
}
