package id.my.hendisantika.springbootquerydslsample.model;

import com.querydsl.core.annotations.QueryProjection;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-querydsl-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/26/24
 * Time: 07:42
 * To change this template use File | Settings | File Templates.
 */
public record MemberResponse(long id, String name) {

    @QueryProjection
    public MemberResponse {
    }
}
