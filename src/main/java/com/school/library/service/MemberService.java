package com.school.library.service;

import com.school.library.entity.Book;
import com.school.library.entity.Member;
import com.school.library.model.request.BookRq;
import com.school.library.model.request.MemberRq;
import com.school.library.model.response.BookRs;
import com.school.library.model.response.MemberRs;
import com.school.library.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;


@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public MemberRs createMemberRs(MemberRq memberRq){
        validationService.validate(memberRq);

        if(memberRepository.existsByEmail(memberRq.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        Member member = new Member();
        member.setName(memberRq.getName());
        member.setPhone(memberRq.getPhone());
        member.setEmail(memberRq.getEmail());
        member.setAddress(memberRq.getAddress());
        member.setJoinDate(new Date());

        memberRepository.save(member);
        return toMemberRs(member);
    }

    public MemberRs toMemberRs(Member member){
        return MemberRs.builder()
                .id(member.getId())
                .name(member.getName())
                .phone(member.getPhone())
                .email(member.getEmail())
                .address(member.getAddress())
                .build();
    }

    @Transactional
    public MemberRs get(Long memberId){
        Member member = memberRepository.findMemberById(memberId);
        if(member == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Member not found");
        }
        return toMemberRs(member);
    }

    @Transactional
    public MemberRs update(Long memberId, MemberRq memberRq){
        validationService.validate(memberRq);

        Member member = memberRepository.findById(String.valueOf(memberId)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        member.setName(memberRq.getName());
        member.setEmail(memberRq.getEmail());
        member.setPhone(memberRq.getPhone());
        member.setAddress(memberRq.getAddress());
        member.setJoinDate(memberRq.getJoinDate());

        memberRepository.save(member);
        return toMemberRs(member);
    }
}
