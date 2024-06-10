package com.wanted_market.api.member.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MemberJoinForm(@NotNull @NotBlank @JsonProperty String name, @NotNull@ NotBlank @JsonProperty String password) {
}
