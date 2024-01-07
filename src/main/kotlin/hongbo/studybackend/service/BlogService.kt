package hongbo.studybackend.service

import hongbo.studybackend.entity.Blog
import hongbo.studybackend.repository.BlogRepository
import org.springframework.stereotype.Service

@Service
class BlogService(
    private val repository: BlogRepository
) {

    fun getMainBlog(): Blog = repository.getReferenceById(1)
}
