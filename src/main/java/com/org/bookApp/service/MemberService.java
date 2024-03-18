package com.org.bookApp.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.org.bookApp.dto.BookDto;
import com.org.bookApp.dto.MemberDto;
import com.org.bookApp.entity.BookEntry;
import com.org.bookApp.entity.Member;
import com.org.bookApp.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	public Member memberDetails(MemberDto memberDto) {
		
		  // Validate input parameters (you may enhance this validation)
        if (memberDto == null) {
            throw new IllegalArgumentException("Invalid MemberDto");
        }
		
		Member member = new Member();
		member.setMember_address(memberDto.getMember_address());
		member.setMember_name(memberDto.getMember_name());
		member.setGender(memberDto.getGender());
		member.setRegisteration_date(new Date());
		member.setRegisteration_expiry(memberDto.getRegisteration_expiry());
		
		Member saveMember=memberRepository.save(member);
		
		return saveMember;
	}
	
	public List<Member> getAllMembers(MemberDto dto){
		return memberRepository.findAll();
	}
	
	
	public Member getMemberById(@PathVariable Long bookId) {
		
		return memberRepository.findById(bookId).orElse(null);
	}
	
	public boolean updateMemberById(Long memberId, Member updatedMember) {
		
        if (memberRepository.existsById(memberId)) {
            updatedMember.setMember_id(memberId);
            memberRepository.save(updatedMember);
            return true; 
        } else {
            return false; 
        }
	}
	
	public Member getMemberById(long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found with id: " + memberId));
    }

}
