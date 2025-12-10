package com.school.library.service;

import com.school.library.entity.Member;
import com.school.library.model.request.CreateMemberRq;
import com.school.library.model.response.CreateMemberRs;
import com.school.library.repository.MemberRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public CreateMemberRs createMemberRs(CreateMemberRq createMemberRq){
        validationService.validate(createMemberRq);

        if(memberRepository.existsByEmail(createMemberRq.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        Member member = new Member();
        member.setName(createMemberRq.getName());
        member.setPhone(createMemberRq.getPhone());
        member.setEmail(createMemberRq.getEmail());
        member.setAddress(createMemberRq.getAddress());

        memberRepository.save(member);
        return CreateMemberRs.builder()
                .id(member.getId())
                .name(member.getName())
                .phone(member.getPhone())
                .email(member.getEmail())
                .address(member.getAddress())
                .build();
    }
}
