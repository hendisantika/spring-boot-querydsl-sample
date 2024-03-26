package id.my.hendisantika.springbootquerydslsample.model;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-querydsl-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/26/24
 * Time: 07:43
 * To change this template use File | Settings | File Templates.
 */
public record TeamResponse(long id,
                           String name,
                           long memberCount,
                           long milestoneCount) {
}
