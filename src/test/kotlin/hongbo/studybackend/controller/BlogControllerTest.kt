package hongbo.studybackend.controller

import com.fasterxml.jackson.databind.ObjectMapper
import hongbo.studybackend.fixture.BlogFixture
import hongbo.studybackend.service.BlogService
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(MockitoExtension::class)
@WebMvcTest(value = [BlogController::class])
class BlogControllerTest {

    companion object {
        const val BASE_PATH = "/api/v1/blog"
    }

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @MockBean
    private lateinit var service: BlogService

    private val blog = BlogFixture.blog

    @Nested
    inner class WhenQuery {

        @Test
        fun `should return main blog`() {
            `when`(service.getMainBlog(any())).thenReturn(blog)

            mockMvc
                .perform(
                    get("$BASE_PATH/1")
                )
                .andExpect(status().isOk)
        }
    }

    @Nested
    inner class WhenCreate {

        @Test
        fun `should return 201 if create blog successfully`() {
            `when`(service.create(any())).thenReturn(blog)

            mockMvc
                .perform(
                    post(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(BlogFixture.createRequest))
                )
                .andExpect(status().isCreated)
        }
    }
}
