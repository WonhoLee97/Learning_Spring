package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired //스프링 컨테이너에 있는 member service에 자동으로 연결해줌
    //MemberController가 생성이 될 때 SpringBin에 등록되어있는 MemberService객체를 가져다가 넣어줌(의존관계 주입)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
