package id.my.hendisantika.springbootquerydslsample.config;

import id.my.hendisantika.springbootquerydslsample.entity.Member;
import id.my.hendisantika.springbootquerydslsample.entity.Team;
import id.my.hendisantika.springbootquerydslsample.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-querydsl-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/26/24
 * Time: 07:56
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
class DataInitializer implements CommandLineRunner {

    private final TeamRepository repository;

    @Override
    @Transactional
    public void run(String... args) {
        Team firstTeam = new Team("First Team");
        firstTeam.addMember(new Member("Yuji"));
        firstTeam.addMember(new Member("Megumi"));
        firstTeam.addMember(new Member("Gojo"));
        firstTeam.addMember(new Member("Nanami"));

        Team secondTeam = new Team("Second Team");
        secondTeam.addMember(new Member("Todo"));
        secondTeam.addMember(new Member("Mei"));
        secondTeam.addMember(new Member("Sukuna"));

        repository.saveAll(List.of(firstTeam, secondTeam));
    }
}
