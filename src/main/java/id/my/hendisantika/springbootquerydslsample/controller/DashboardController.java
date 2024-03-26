package id.my.hendisantika.springbootquerydslsample.controller;

import id.my.hendisantika.springbootquerydslsample.entity.Team;
import id.my.hendisantika.springbootquerydslsample.model.TeamResponse;
import id.my.hendisantika.springbootquerydslsample.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-querydsl-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/26/24
 * Time: 07:59
 * To change this template use File | Settings | File Templates.
 */
@Controller
@ResponseBody
@RequiredArgsConstructor
class DashboardController {

    private final TeamRepository teamRepository;

    @GetMapping("/v1/dashboard")
    public List<TeamResponse> dashboard1() {
        List<Team> all = teamRepository.findAllUsingJoinFetch();
        return all.stream()
                .map(team -> new TeamResponse(team.getId(), team.getName(), team.getMembers().size(), team.getMilestones().size()))
                .toList();
    }
}
