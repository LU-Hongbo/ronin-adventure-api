package hongbo.studybackend.service

import hongbo.studybackend.controller.request.BlogCreateRequest
import hongbo.studybackend.entity.Blog
import hongbo.studybackend.repository.BlogRepository
import org.springframework.stereotype.Service

@Service
class BlogService(
    private val repository: BlogRepository
) {

    fun getMainBlog(): Blog = repository.getReferenceById(1)

    fun create(request: BlogCreateRequest): Blog {
        val blog = Blog(
            id = 1,
            name = request.name
        )
        return repository.save(blog)
    }
}
