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
import org.mockito.kotlin.doNothing
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
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
        fun `should return blog given id`() {
            `when`(service.getById(any())).thenReturn(blog)

            mockMvc
                .perform(
                    get("$BASE_PATH/{id}", blog.id),
                )
                .andExpect(status().isOk)
        }
    }

    @Nested
    inner class WhenCreate {
        @Test
        fun `should create blog successfully`() {
            `when`(service.create(any())).thenReturn(blog)

            mockMvc
                .perform(
                    post(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(BlogFixture.createRequest)),
                )
                .andExpect(status().isCreated)
        }
    }

    @Nested
    inner class WhenUpdate {
        @Test
        fun `should return updated blog given new blog`() {
            val updated = BlogFixture.generate(id = 1, name = "AAPL")
            `when`(service.update(any())).thenReturn(updated)

            mockMvc
                .perform(
                    put(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(BlogFixture.updateRequest)),
                )
                .andExpect(status().isOk)
        }
    }

    @Nested
    inner class WhenDelete {
        @Test
        fun `should delete blog given id`() {
            val nonexistentId = 1
            doNothing().`when`(service).deleteById(any())

            mockMvc
                .perform(
                    delete("$BASE_PATH/{id}", nonexistentId),
                )
                .andExpect(status().isOk)
        }
    }
}
