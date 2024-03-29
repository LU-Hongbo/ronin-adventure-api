package ronin.adventure.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ronin.adventure.controller.request.BlogCreateRequest
import ronin.adventure.controller.request.BlogUpdateRequest
import ronin.adventure.controller.response.BlogResponse
import ronin.adventure.controller.response.BlogResponse.Companion.toResponse
import ronin.adventure.service.BlogService

@RestController
@RequestMapping("/api/v1/blog")
class BlogController(
    private val service: BlogService,
) {
    @GetMapping("/{id}")
    fun getById(
        @PathVariable id: Long,
    ): BlogResponse {
        return service.getById(id).toResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @RequestBody blogCreateRequest: BlogCreateRequest,
    ): BlogResponse {
        return service.create(blogCreateRequest).toResponse()
    }

    @PutMapping
    fun update(
        @RequestBody blogUpdateRequest: BlogUpdateRequest,
    ): BlogResponse {
        return service.update(blogUpdateRequest).toResponse()
    }

    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable id: Long,
    ) {
        service.deleteById(id)
    }
}
