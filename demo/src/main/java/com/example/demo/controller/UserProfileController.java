package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserProfile;

@RestController
public class UserProfileController {
	
	private Map<String, UserProfile> userMap;
	
	@PostConstruct
	public void init() {
		userMap = new HashMap<String, UserProfile>();
		userMap.put("1", new UserProfile("1", "홍길동", "111-1111", "서울시 강남구 대치1동"));
		userMap.put("2", new UserProfile("2", "홍길자", "111-1112", "서울시 강남구 대치2동"));
		userMap.put("3", new UserProfile("3", "홍길순", "111-1113", "서울시 강남구 대치3동"));
	}
	
	// http://localhost:8000/
	// Get = 조회 , Post = 생성 , Put = 수정 ,  Delete = 삭제
	
	@GetMapping("/user/{id}") // 사용자 id를 기준으로 정보 조회
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return userMap.get(id);
	}
	
	@GetMapping("/user/all") // 전체 사용자 정보 조회
	public List<UserProfile> getUserProfileList() {
		return new ArrayList<UserProfile>(userMap.values());
	}
	
	@PutMapping("/user/{id}") // id를 기준으로 사용자 정보 생성
	public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		UserProfile userProfile = new UserProfile(id, name, phone, address);
		userMap.put(id, userProfile);
	}
	
	@PostMapping("/user/{id}") // id를 기준으로 사용자 정보 수정
	public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		UserProfile userProfile = userMap.get(id);
		userProfile.setName(name);
		userProfile.setPhone(phone);
		userProfile.setAddress(address);
	}
	
	@DeleteMapping("/user/{id}") // id를 기준으로 사용자 정보 삭제
	public void deleteUserProfile(@PathVariable("id") String id) {
		userMap.remove(id);
	}
	

}
