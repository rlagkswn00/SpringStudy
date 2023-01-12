package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;
    // 하나만 만들어 놓고 사용


    //AutoWired 해놓으면 컨테이너에 있는 변수를 여기다가 입력함.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}