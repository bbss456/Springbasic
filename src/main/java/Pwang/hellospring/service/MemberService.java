package Pwang.hellospring.service;

import Pwang.hellospring.domain.Member;
import Pwang.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member){
        validataDuplicateMember(member);//중복회원 제거
        memberRepository.save(member);
        //같은 이름이 있는 중복 회원X
        return  member.getId();
    }

    private  void validataDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberID){
        return memberRepository.findByID(memberID);
    }

}
