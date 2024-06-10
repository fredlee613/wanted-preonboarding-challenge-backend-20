package com.wanted_market.api.member.controller;

import com.wanted_market.api.member.dto.request.MemberJoinForm;
import com.wanted_market.api.member.dto.response.MemberResponseDTO;
import com.wanted_market.api.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<Long> join(@Valid @RequestBody MemberJoinForm form) {
        return ResponseEntity.ok(memberService.join(form));
    }

    @GetMapping()
    public ResponseEntity<List<MemberResponseDTO>> findAll() {
        return ResponseEntity.ok(memberService.findAll());
    }
}
