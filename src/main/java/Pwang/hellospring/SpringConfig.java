package Pwang.hellospring;

import Pwang.hellospring.repository.JdbcMemberRepository;
import Pwang.hellospring.repository.JpaMemberRepository;
import Pwang.hellospring.repository.MemberRepository;
import Pwang.hellospring.repository.MemoryMemberRepository;
import Pwang.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}