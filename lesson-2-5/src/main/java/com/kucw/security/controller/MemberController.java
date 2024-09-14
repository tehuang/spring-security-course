package com.kucw.security.controller;

import com.kucw.security.dao.MemberDao;
import com.kucw.security.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @Autowired
    private MemberDao memberDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Member register(@RequestBody Member member){
        //Ignore parameters checking

        //Hashed Password
        String hashedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(hashedPassword);

        //Insert a member into database
        Integer memberId = memberDao.createMember(member);
        return memberDao.getMemberById(memberId);
    }
}
