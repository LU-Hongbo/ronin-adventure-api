package hongbo.studybackend.controller

import hongbo.studybackend.service.BlogService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(MockitoExtension::class)
@SpringBootTest(classes = [BlogController::class])
@AutoConfigureMockMvc
class BlogControllerTest {

    companion object {
        const val BASE_PATH = "/api/v1/blog"
    }

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var service: BlogService

    @Test
    fun `should return main blog list`() {
        `when`(service.getMainBlog()).thenReturn("TWKS")

        mockMvc.perform(
            get(BASE_PATH)
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$").value("TWKS"))
    }
}
