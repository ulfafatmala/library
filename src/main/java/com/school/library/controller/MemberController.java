package com.school.library.controller;

import com.school.library.model.request.MemberRq;
import com.school.library.model.response.MemberRs;
import com.school.library.model.response.GenericResponse;
import com.school.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping(path = "/api/member",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces =  MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse<MemberRs> create(@RequestBody MemberRq memberRq) {
        MemberRs createMemberRs = memberService.createMemberRs(memberRq);
        return GenericResponse.<MemberRs>builder().data(createMemberRs).build();
    }

    @GetMapping(path = "/api/member/{memberId}",
    produces =  MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse<MemberRs> get(@PathVariable Long memberId) {
        MemberRs getMemberRs = memberService.get(memberId);
        return GenericResponse.<MemberRs>builder().data(getMemberRs).build();
    }

}
