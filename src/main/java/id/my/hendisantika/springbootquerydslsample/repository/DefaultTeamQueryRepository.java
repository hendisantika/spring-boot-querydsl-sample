package id.my.hendisantika.springbootquerydslsample.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import id.my.hendisantika.springbootquerydslsample.model.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

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

    public List<MemberResponse> findMembersByTeamId(long teamId) {
        QMember memberTable = new QMember("member");

        return queryFactory
                .select(
                        new QMemberResponse(
                                memberTable.id,
                                memberTable.name
                        )
                )
                .from(memberTable)
                .where(
                        memberTable.team.id.eq(teamId)
                )
                .fetch();
    }

    public List<MemberResponse> searchMembersByTeamId(long teamId, String searchText) {
        QMember memberTable = new QMember("member");

        return queryFactory
                .select(
                        new QMemberResponse(
                                memberTable.id,
                                memberTable.name
                        )
                )
                .from(memberTable)
                .where(
                        memberTable.team.id.eq(teamId),
                        nameLike(searchText)
                )
                .fetch();
    }

    private BooleanExpression nameLike(String searchText) {
        if (!StringUtils.hasText(searchText)) {
            return null;
        }

        QMember memberTable = new QMember("member");
        return memberTable.name.containsIgnoreCase(searchText);
    }


}
