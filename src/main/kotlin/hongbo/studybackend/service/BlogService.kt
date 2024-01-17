package hongbo.studybackend.service

import hongbo.studybackend.controller.request.BlogCreateRequest
import hongbo.studybackend.controller.request.BlogUpdateRequest
import hongbo.studybackend.entity.Blog
import hongbo.studybackend.repository.BlogRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class BlogService(
    private val repository: BlogRepository,
) {
    private val logger = LoggerFactory.getLogger(BlogService::class.simpleName)

    fun getById(id: Long): Blog {
        val blog = repository.findById(id)
        if (blog.isEmpty) {
            logger.error("Blog id $id not exists.")
            throw IllegalArgumentException()
        }
        return blog.get()
    }

    fun create(request: BlogCreateRequest): Blog {
        val blog =
            Blog(
                name = request.name,
            )
        return repository.save(blog)
    }

    fun update(request: BlogUpdateRequest): Blog {
        if (repository.findById(request.id).isEmpty) {
            logger.error("Blog id ${request.id} not exists.")
            throw IllegalArgumentException()
        }

        return repository.save(request.toEntity())
    }

    fun deleteById(id: Long) {
        if (repository.findById(id).isEmpty) {
            logger.error("Blog id $id not exists.")
            throw IllegalArgumentException()
        }

        repository.deleteById(id)
    }
}
