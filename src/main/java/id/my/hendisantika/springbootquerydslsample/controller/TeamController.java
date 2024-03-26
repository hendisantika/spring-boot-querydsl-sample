package id.my.hendisantika.springbootquerydslsample.controller;

import id.my.hendisantika.springbootquerydslsample.model.MemberResponse;
import id.my.hendisantika.springbootquerydslsample.repository.DefaultTeamQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-querydsl-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/26/24
 * Time: 07:57
 * To change this template use File | Settings | File Templates.
 */
@Controller
@ResponseBody
@RequiredArgsConstructor
class TeamController {

    private final DefaultTeamQueryRepository query;

    @GetMapping("/v1/teams/{teamId}/members")
    public List<MemberResponse> members(@PathVariable long teamId) {
        return query.findMembersByTeamId(teamId);
    }

    @GetMapping("/v2/teams/{teamId}/members")
    public List<MemberResponse> searchMembers(@PathVariable long teamId, @RequestParam(required = false) String searchText) {
        return query.searchMembersByTeamId(teamId, searchText);
    }

    @GetMapping("/v3/members")
    public Page<MemberResponse> paginatedMembers(Pageable pageable) {
        return query.members(pageable);
    }
}
