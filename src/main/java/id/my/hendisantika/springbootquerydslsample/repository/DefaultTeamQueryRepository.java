package id.my.hendisantika.springbootquerydslsample.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-querydsl-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/26/24
 * Time: 07:44
 * To change this template use File | Settings | File Templates.
 */
@Repository
@RequiredArgsConstructor
public class DefaultTeamQueryRepository {

    private final JPAQueryFactory queryFactory;

}
