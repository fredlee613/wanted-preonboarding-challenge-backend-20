package com.wanted_market.api.member.service;

import com.wanted_market.api.member.dto.request.MemberJoinForm;
import com.wanted_market.api.member.dto.response.MemberResponseDTO;
import com.wanted_market.api.member.entity.Member;
import com.wanted_market.api.member.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(MemberJoinForm form) {
        // 이름 중복 검증 후 있을 경우 예외 처리
        if (isNameDuplicated(form.name())) throw new IllegalArgumentException(String.format("%s is already exists.", form.name()));
        Member member = Member.builder()
                .name(form.name())
                .password(form.password())
                .build();
        return memberRepository.save(member).getId();
    }

    public List<MemberResponseDTO> findAll() {
        return memberRepository.findAll().stream()
                .map(member -> new MemberResponseDTO(member.getId(), member.getName(), member.getPassword()))
                .collect(Collectors.toList());
    }

    private boolean isNameDuplicated(String name) {
        return memberRepository.findByName(name).isPresent();
    }

}
