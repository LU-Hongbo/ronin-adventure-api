package ronin.adventure.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ronin.adventure.entity.Blog

@Repository
interface BlogRepository : JpaRepository<Blog, Long>
