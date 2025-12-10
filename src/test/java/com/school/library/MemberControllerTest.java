package com.school.library;

import com.school.library.model.request.CreateMemberRq;
import com.school.library.model.response.GenericResponse;
import com.school.library.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MemberRepository memberRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void createMemberBadRequest() throws  Exception {
        CreateMemberRq createMemberRq = new CreateMemberRq();
        createMemberRq.setName("");
        createMemberRq.setEmail("salah");
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        HttpEntity<CreateMemberRq> request = new HttpEntity<>(createMemberRq, headers);
        
        ResponseEntity<String> response = restTemplate.postForEntity("/api/member", request, String.class);
        
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        GenericResponse<String> genericResponse = objectMapper.readValue(response.getBody(), new TypeReference<GenericResponse<String>>() {});
        assertNotNull(genericResponse.getErrors());
    }
}
