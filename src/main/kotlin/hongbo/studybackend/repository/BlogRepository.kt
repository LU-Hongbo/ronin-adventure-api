package hongbo.studybackend.repository

import hongbo.studybackend.entity.Blog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlogRepository : JpaRepository<Blog, Long>
