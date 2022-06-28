package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member = new Member(req.getParameter("userName"), Integer.parseInt(req.getParameter("age")));
        memberRepository.save(member);
        req.setAttribute("member", member);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/save-result.jsp");
        dispatcher.forward(req, resp);
    }
}
