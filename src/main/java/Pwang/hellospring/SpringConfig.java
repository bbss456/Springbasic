package Pwang.hellospring;

import Pwang.hellospring.repository.MemberRepository;
import Pwang.hellospring.repository.MemoryMemberRepository;
import Pwang.hellospring.service.MemberService;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean  // 직접 스프링 빈 등록
   public MemberService memberService() {
        return new MemberService(memberRepository()); //스프링에 등록된 memberRepository DI 주입
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
