package hongbo.studybackend.service

import hongbo.studybackend.repository.BlogRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class BlogServiceTest {

    @InjectMocks
    lateinit var service: BlogService

    @Mock
    lateinit var repository: BlogRepository

    @Test
    fun `should return main blog`() {
        `when`(repository.getMainBlog()).thenReturn("TWKS")

        val result = service.getMainBlog()

        assert(result.equals("TWKS"))
    }
}
