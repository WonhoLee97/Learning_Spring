package hello.core.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository = new MemoryMemeberRepository(); //구현체가 없기에 Null포인터로 터질 수 있어 구현 객체를 선택해줘야 함, 추상화와 구체화를 모두 의존, DIP위반

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberID) {
        return memberRepository.findById(memberID);
    }
}
