package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemeberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; //= new MemoryMemeberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //구현클래스에도 의존. DIP 위반
    //즉, discountPolicy를 바꾸기 위해서는 OrderServiceImple도 건드려야 함. OCP 위반
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final DiscountPolicy discountPolicy; //Interface에만 의존

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) { //의존관계 주입
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
