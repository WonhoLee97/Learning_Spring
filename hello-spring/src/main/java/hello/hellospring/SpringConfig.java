package hello.hellospring;


import hello.hellospring.domain.Member;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration //상황에 따라 구현 클래스를 변경(DB가 아직 결정되지 않았다는 시나리오 가정
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

//    private EntityManager em;
//
//    //private DataSource dataSource;
//
////    @Autowired
////    public SpringConfig(DataSource dataSource){
////        this.dataSource=dataSource;
////    }
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em=em;
//    }

    @Bean //Spring bean에 등록
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        //return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
