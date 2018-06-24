package com.example.jpetstore.controller;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.KakaoLoginService;
import com.example.jpetstore.service.PetStoreFacade;
import com.example.jpetstore.service.PetStoreImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("userSession")
@RequestMapping(value = "http://localhost:8080/jpetstore/shop/index.do" , produces = "application/json", method = (RequestMethod.GET))
public class KakaoLoginController {

	KakaoLoginService kakaoLoginService;
		 
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
//
//	@ModelAttribute("categories")
//	public List<Category> getCategoryList() {
//		return petStore.getCategoryList();
//	}
	
	@RequestMapping(value="/kakaologin", produces="application/json", method = {RequestMethod.GET, RequestMethod.POST})
	public String kakaoLogin(@RequestParam("code") String code, HttpServletRequest request, HttpServletResponse httpServletResponse) {
		System.out.println("code: " + code);
		
		JsonNode jsonToken = KakaoLogin.getAccessToken(code);
		System.out.println("JSON 반환 : " + jsonToken.get("access_token"));
		
		Account account = new Account();
		
		//사용자 정보 요청
        JsonNode userInfo = KakaoLogin.getKakaoUserInfo(code);
    
        // Get id
 		String id = userInfo.path("id").asText();
 		String nickname = null;
 		String thumbnailImage = null;
 		String profileImage = null;
 		String message = null;

        // 유저정보 카톡에서 가져오기 Get properties

		JsonNode properties = userInfo.path("properties");
		if (properties.isMissingNode()) {
			// if "name" node is missing
		} else {
			nickname = properties.path("nickname").asText();
			thumbnailImage = properties.path("thumbnail_image").asText();
			profileImage = properties.path("profile_image").asText();

			System.out.println("nickname : " + nickname);
			System.out.println("thumbnailImage : " + thumbnailImage);
			System.out.println("profileImage : " + profileImage);
			
			account.setUsername(nickname);
			account.setProfileImagePath(profileImage);

		}
		kakaoLoginService.kakaoLogin(account);

		return "index";
	
	}


//	@ModelAttribute("userSession")
//	public AccountForm KakaoLogin(@RequestParam("code") String code,
//			HttpServletRequest request, HttpServletResponse response, HttpSession session,
//			@ModelAttribute("accountForm") AccountForm accountForm) 
//					throws Exception{
//		System.out.println("asdf");
////	Account account = new Account();
//
//	  JsonNode token = KakaoLogin.getAccessToken(code);
//	
//	  JsonNode profile = KakaoLogin.getKakaoUserInfo(token.path("access_token").toString());
//
//	  Account properties = KakaoLogin.changeData(profile);
////	  
////	  String username = properties.getUsername();
//
////	  account.setUsername(username);
////	  account.setProfileImagePath(properties.getProfileImagePath());
//	  
//	  kakaoLoginService.kakaoLogin(properties);
//
//	  session.setAttribute("login", properties);
//
//	  System.out.println("카카오로그인" + properties.getUsername());
//
////	  UserSession userSession = new UserSession(properties);
//	  
//	  UserSession userSession = new UserSession(
//			petStore.getAccount(accountForm.getAccount().getUsername()));
//	  
////		PagedListHolder<Product> myList = new PagedListHolder<Product>(
////			petStore.getProductListByCategory(accountForm.getAccount().getFavouriteCategoryId()));
////		myList.setPageSize(4);
////		userSession.setMyList(myList);
//		session.setAttribute("userSession", userSession);
//
//	  return new AccountForm();
//	}
//	
//	@ModelAttribute("userSession")
//	public AccountForm formBackingObject(HttpServletRequest request) 
//			throws Exception {
//		UserSession userSession = 
//			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
//		if (userSession != null) {	// edit an existing account
//			return new AccountForm(
//				petStore.getAccount(userSession.getAccount().getUsername()));
//		}
//		else {	// create a new account
//			return new AccountForm();
//		}
//	}
}