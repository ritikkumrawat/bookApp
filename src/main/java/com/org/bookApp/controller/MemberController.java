package com.org.bookApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.org.bookApp.dto.MemberDto;
import com.org.bookApp.entity.BookEntry;
import com.org.bookApp.entity.Member;
import com.org.bookApp.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping(value = "/post")
	public Member postBook(@RequestBody MemberDto dto) {
		return memberService.memberDetails(dto);
	}
	
	@GetMapping("/get")
	public List<Member> getAll(MemberDto dto){
		return memberService.getAllMembers(dto);
	}
	
	
	@GetMapping("/getMember/{byId}")
	public ResponseEntity<Member> getMemberById(@PathVariable Long byId) {
		Member member=memberService.getMemberById(byId);
		
		if ( member != null) {
            return new ResponseEntity<>(member, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }	
	}
	
	@PutMapping("/update/{id}")
    public ResponseEntity<String> updateMemberById(@RequestParam Long id, @RequestBody Member updatedMember) {
        boolean updated = memberService.updateMemberById(id, updatedMember);

        if (updated) {
            return ResponseEntity.ok("Member updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with the given ID not found");
        }
	}
	
	
	
	
}
