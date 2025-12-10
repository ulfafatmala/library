package com.school.library;

import com.school.library.entity.Member;
import com.school.library.model.request.CreateMemberRq;
import com.school.library.model.response.CreateMemberRs;
import com.school.library.model.response.GenericResponse;
import com.school.library.repository.MemberRepository;
import com.school.library.repository.RentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private RentRepository rentRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup(){
        rentRepository.deleteAll();
        memberRepository.deleteAll();

        Member member = new Member();
        member.setName("test");
        member.setEmail("random@gmail.com");
        member.setAddress("test");
        member.setPhone("test");
        member.setJoinDate(new Date());
        memberRepository.save(member);
    }

    @Test
    void createMemberBadRequest() throws  Exception {
        CreateMemberRq request = new CreateMemberRq();
        request.setName("");
        request.setEmail("salah");
        request.setAddress("test");
        request.setPhone("test");

        mockMvc.perform(post("/api/member")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(result -> {
                        GenericResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(),
                        new TypeReference<GenericResponse<String>>(){});
        assertNotNull(response.getError());
        });
    }

    @Test
    void createMemberSuccess() throws  Exception {
        CreateMemberRq request = new CreateMemberRq();
        request.setName("Ulfa");
        request.setEmail("ulfafatmala@gmail.com");
        request.setAddress("Depok");
        request.setPhone("62819999900");

        mockMvc.perform(post("/api/member")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().is2xxSuccessful()
        ).andDo(result -> {
            GenericResponse<CreateMemberRs> response = objectMapper.readValue(result.getResponse().getContentAsString(),
                    new TypeReference<>(){});
            assertNull(response.getError());
            assertEquals("Ulfa", response.getData().getName());
            assertEquals("ulfafatmala@gmail.com", response.getData().getEmail());
            assertEquals("Depok", response.getData().getAddress());
            assertEquals("62819999900", response.getData().getPhone());

            assertTrue(memberRepository.existsById(String.valueOf(response.getData().getId())));
        });
    }
}
