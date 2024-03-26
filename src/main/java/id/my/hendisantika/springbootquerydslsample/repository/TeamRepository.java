package id.my.hendisantika.springbootquerydslsample.repository;

import id.my.hendisantika.springbootquerydslsample.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
