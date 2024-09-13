package com.kucw.security.security;

import com.kucw.security.dao.MemberDao;
import com.kucw.security.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Inquire member info from database
        Member member = memberDao.getMemberByEmail(username);
        if(member==null){
            throw  new UsernameNotFoundException("Member not found for: "+username);
        }else{
            String memberEmail = member.getEmail();
            String memberPassword = member.getPassword();
            List<GrantedAuthority> authorities = new ArrayList<>();
            //Transform to Spring Security user's format
            return new User(memberEmail,memberPassword, authorities);
        }

    }
}
