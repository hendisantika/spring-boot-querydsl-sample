package id.my.hendisantika.springbootquerydslsample.repository;

import id.my.hendisantika.springbootquerydslsample.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-querydsl-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/26/24
 * Time: 07:48
 * To change this template use File | Settings | File Templates.
 */
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("""
            select distinct t
                from Team t
                left join fetch t.members
            """)
    List<Team> findAllUsingJoinFetch();

    @EntityGraph(attributePaths = {
            "members", "milestones"
    })
    List<Team> findAll();

    @EntityGraph(attributePaths = {
            "members", "milestones"
    })
    Page<Team> findAll(Pageable pageable);
}
