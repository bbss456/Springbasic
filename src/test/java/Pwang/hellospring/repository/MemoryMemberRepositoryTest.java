package Pwang.hellospring.repository;
import Pwang.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //함수 끝날때 마다 실행됨.
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member result = repository.findByid(member.getId()).get();
        //Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);

    }

    @Test
    public  void findByName() {
        Member member1 =new Member();
        member1.setName("sprint1");
        repository.save(member1);

        Member member2 =new Member();
        member2.setName("sprint2");
        repository.save(member2);

        Member result = repository.findByName("sprint1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 =new Member();
        member1.setName("sprint1");
        repository.save(member1);

        Member member2 =new Member();
        member2.setName("sprint2");
        repository.save(member2);

        List<Member> resutl = repository.findAll();
        assertThat(resutl.size()).isEqualTo(2) ;
    }


}