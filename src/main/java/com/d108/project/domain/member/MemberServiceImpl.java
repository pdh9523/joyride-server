package com.d108.project.domain.member;


import com.d108.project.domain.logincredential.LoginCredential;
import com.d108.project.domain.logincredential.LoginCredentialRepository;
import com.d108.project.domain.member.dto.MemberLoginDto;
import com.d108.project.domain.member.dto.MemberRegisterDto;
import com.d108.project.domain.member.dto.MemberResponseDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final LoginCredentialRepository loginCredentialRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, LoginCredentialRepository loginCredentialRepository) {
        this.memberRepository = memberRepository;
        this.loginCredentialRepository = loginCredentialRepository;
    }

    @Override
    @Transactional
    public void registerMember (MemberRegisterDto memberRegisterDto) {

        LoginCredential loginCredential = LoginCredential.builder()
                .username(memberRegisterDto.getUsername())
                .password(passwordEncoder.encode(memberRegisterDto.getPassword()))
                .build();

        Member member = Member.builder()
                .nickname(memberRegisterDto.getNickname())
                .loginCredential(loginCredential)
                .build();

        loginCredential.setMember(member);

        memberRepository.save(member);
    }

    @Override
    public MemberResponseDto loginMember(MemberLoginDto memberLoginDto) {
        LoginCredential loginCredential = loginCredentialRepository.findByUsername(memberLoginDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디 입니다."));

        if (passwordEncoder.matches(memberLoginDto.getPassword(), loginCredential.getPassword())) {
            return MemberResponseDto.builder()
                    .username(loginCredential.getUsername())
                    .nickname(loginCredential.getMember().getNickname())
                    .build();
        } else {
            throw new IllegalArgumentException("비밀번호가 올바르지 않습니다.");
        }
    }
    // 전체 조회
    @Override
    public List<MemberResponseDto> getAllMember() {
        List<Member> members = memberRepository.findAll();

        return members.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public MemberResponseDto convertToResponseDto(Member member) {
        return MemberResponseDto.builder()
                .id(member.getId())
                .username(member.getLoginCredential().getUsername())
                .nickname(member.getNickname())
                .build();
    }
}
