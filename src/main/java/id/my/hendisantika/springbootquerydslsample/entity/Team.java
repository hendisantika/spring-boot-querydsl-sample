package id.my.hendisantika.springbootquerydslsample.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-querydsl-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/26/24
 * Time: 07:47
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private List<Member> members;

    @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private List<Milestone> milestones;

    public Team(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.milestones = new ArrayList<>();
    }

    public void addMember(Member member) {
        this.members.add(member);
        member.setTeam(this);
    }

    public void addMilestone(Milestone milestone) {
        this.milestones.add(milestone);
        milestone.setTeam(this);
    }
}
