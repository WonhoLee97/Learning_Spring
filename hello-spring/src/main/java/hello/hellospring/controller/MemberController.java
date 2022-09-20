package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    //@Autowired private MemberService memberService;(필드 주입, 중간에 바꿀 수 있는 방법이 없음)

    private MemberService memberService;

    /*private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/ //Setter Injection

    @Autowired //스프링 컨테이너에 있는 member service에 자동으로 연결해줌
    //MemberController가 생성이 될 때 SpringBean에 등록되어있는 MemberService객체를 가져다가 넣어줌(의존관계 주입)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    } //어플리케이션이 조립되는 과정에서 실행되고 끝남

    @GetMapping("/members/new") //Get방식으로 들어옴
    public String createForm() {
        return "members/createMemberForm"; //여기로 이동, ViewController에서 html결정
    }

    @PostMapping("/members/new") //Post받음
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName()); //get

        memberService.join(member); //join

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
