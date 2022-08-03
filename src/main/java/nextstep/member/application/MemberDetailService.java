package nextstep.member.application;

import nextstep.auth.user.UserDetailsService;
import nextstep.member.domain.LoginMember;
import nextstep.member.domain.Member;
import nextstep.member.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public MemberDetailService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Transactional(readOnly = true)
    public LoginMember loadUserByUsername(String username) {
        Member member = memberRepository.findByEmail(username).orElseThrow(RuntimeException::new);
        return LoginMember.of(member);
    }
}