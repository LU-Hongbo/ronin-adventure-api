package hongbo.studybackend.controller

import hongbo.studybackend.service.BlogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/blog")
class BlogController(
    private val service: BlogService
) {

    @GetMapping
    fun getMainBlog() = service.getMainBlog()
}
