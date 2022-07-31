package nextstep.member.application;

import nextstep.member.domain.LoginMember;
import nextstep.member.domain.Member;
import nextstep.member.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginMemberService {
    private MemberRepository memberRepository;

    public LoginMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Transactional(readOnly = true)
    public LoginMember loadUserByUsername(String email) {
        Member member = memberRepository.findByEmail(email).orElseThrow(RuntimeException::new);
        return LoginMember.of(member);
    }
}
