package hongbo.studybackend.controller

import hongbo.studybackend.controller.request.BlogCreateRequest
import hongbo.studybackend.controller.response.BlogResponse
import hongbo.studybackend.controller.response.BlogResponse.Companion.toResponse
import hongbo.studybackend.service.BlogService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/blog")
class BlogController(
    private val service: BlogService
) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): BlogResponse {
        return service.getById(id).toResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody blogCreateRequest: BlogCreateRequest): BlogResponse {
        return service.create(blogCreateRequest).toResponse()
    }
}
