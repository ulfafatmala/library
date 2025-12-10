package com.school.library.controller;

import com.school.library.model.request.CreateMemberRq;
import com.school.library.model.response.CreateMemberRs;
import com.school.library.model.response.GenericResponse;
import com.school.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping(path = "/api/member",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces =  MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse<CreateMemberRs> create(CreateMemberRq createMemberRq) {
        CreateMemberRs createMemberRs = memberService.createMemberRs(createMemberRq);
        return GenericResponse.<CreateMemberRs>builder().data(createMemberRs).build();
    }
}
