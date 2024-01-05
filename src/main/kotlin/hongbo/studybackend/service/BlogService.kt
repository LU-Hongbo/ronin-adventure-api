package hongbo.studybackend.service

import hongbo.studybackend.repository.BlogRepository
import org.springframework.stereotype.Service

@Service
class BlogService(
    private val repository: BlogRepository
) {

    fun getMainBlog() = repository.getMainBlog()
}
