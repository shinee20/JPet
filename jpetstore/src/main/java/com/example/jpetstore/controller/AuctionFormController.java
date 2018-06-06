package com.example.jpetstore.controller;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
>>>>>>> df2fe0683ad68c2f62a85701e553daf74258cca8

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.jpetstore.dao.SequenceDao;
import com.example.jpetstore.domain.Auction;
<<<<<<< HEAD
import com.example.jpetstore.domain.QA;
=======
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.AuctionService;
>>>>>>> df2fe0683ad68c2f62a85701e553daf74258cca8
import com.example.jpetstore.service.PetStoreFacade;


@Controller
@SessionAttributes("userSession")
public class AuctionFormController {
	
	@Value("tiles/AuctionList")
	private String auctionList;
	private PetStoreFacade petStore;
	
	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	private Item item;
	
	@Autowired
	private AuctionService auctionService;
	
	@Autowired
	private SequenceDao sequenceDao;
	
	private Auction auction;
	
<<<<<<< HEAD
	@ModelAttribute("AucList")
	public List<Auction> getQAList(){
		List<Auction> aucList = new ArrayList<Auction>();
		return aucList;
	}
	
	@RequestMapping("/auction/auclist.do") //���� ��� 
	public String allAuction(@ModelAttribute("AucList") List<Auction> aucList) throws Exception {
		//aucStatus�� true �� �� �𵨿� put
		
		return auctionList;
		
	}
	
//	@Autowired
//	public void setAutcion(Auction auction) {
//		this.auction = auction;
//	}

	@RequestMapping("/auction/newAuction.do") //���� model �� ��� 
	public String nowAuction(
			@RequestParam("auction_Num") String auction_Num,
			ModelMap model) throws Exception {
		//aucStatus�� false �� �� �𵨿� put
=======

	@RequestMapping("/auction/newAuction.do") //옥션 model 에 담기 
	public String nowAuction(
			@RequestParam("auction_Num") String auction_Num,
			ModelMap model) throws Exception {
		//aucStatus가 false 인 것 모델에 put
>>>>>>> df2fe0683ad68c2f62a85701e553daf74258cca8
		
		return "NowAuction";
		
		}
	
<<<<<<< HEAD
	@RequestMapping("/auction/pastAuction.do") //���� ��� 
	public String pastAuction(
			@RequestParam("auction_Num") String auction_Num,
			ModelMap model) throws Exception {
		//aucStatus�� true �� �� �𵨿� put
=======
	@RequestMapping("/auction/auclist.do") //지난 경매 
	public String pastAuction(
			@RequestParam("auction_Num") String auction_Num,
			ModelMap model) throws Exception {
		//aucStatus가 true 인 것 모델에 put
>>>>>>> df2fe0683ad68c2f62a85701e553daf74258cca8
		
		return "PastAuction";
		
	}
	
<<<<<<< HEAD
	@RequestMapping("/auction/aucInputPrice.do") //���� �Է��ϱ� 
=======
	@RequestMapping("/auction/aucInputPrice.do") //가격 입력하기 
>>>>>>> df2fe0683ad68c2f62a85701e553daf74258cca8
	public String inputPriceAuction(
			@RequestParam("auction_Num") String auction_Num,
			@ModelAttribute("userSession") UserSession userSession,
			ModelMap model) throws Exception {
<<<<<<< HEAD
		//aucparti�� price���� ����� id�� �ִ´�.
=======
		//aucparti에 price값과 사용자 id를 넣는다.
>>>>>>> df2fe0683ad68c2f62a85701e553daf74258cca8
		
		return "AucPage";
		
		}
	
<<<<<<< HEAD
	@RequestMapping("/auction/aucOk.do") //�����ϱ� 
=======
	@RequestMapping("/auction/aucOk.do") //낙찰하기 
>>>>>>> df2fe0683ad68c2f62a85701e553daf74258cca8
	public String okAuction(
			@RequestParam("auction_Num") String auction_Num,
			@ModelAttribute("maxPrice") String maxPrice,
			ModelMap model) throws Exception {
<<<<<<< HEAD
		//maxPrice�� ������ ã�� 
=======
		//maxPrice가 누군지 찾기 
>>>>>>> df2fe0683ad68c2f62a85701e553daf74258cca8
		
		return "AucPage";
		
		}				

<<<<<<< HEAD
	@RequestMapping("/auction/aucFail.do") //���� ���� 
=======
	@RequestMapping("/auction/aucFail.do") //낙찰 포기 
>>>>>>> df2fe0683ad68c2f62a85701e553daf74258cca8
	public String failAuction(
			@RequestParam("auction_Num") String auction_Num,
			@ModelAttribute("maxPrice") String maxPrice,
			ModelMap model) throws Exception {
<<<<<<< HEAD
		//service �� ������ 
=======
		//service 로 보내기 
>>>>>>> df2fe0683ad68c2f62a85701e553daf74258cca8
		
		return "AuctionService";
		
		}	
	@RequestMapping("/auction/sendAuctionPost.do")
	public String sendAuctionPost(HttpServletRequest request, @ModelAttribute("auctionForm") AuctionForm auctionForm, Model model, @ModelAttribute("userSession") UserSession userSession) throws ParseException {
		String username = userSession.getAccount().getUsername();
		System.out.println(username);
		
		int item_seq = 203;
		int product_seq = item_seq;
		
		System.out.println(item_seq + " " + product_seq);
		
		String id = "P2P-" + (item_seq);
		String pro_id;
		
		if (auctionForm.getCategory().equals("FISH")) {
			pro_id = "P2P-FI-" + (product_seq);
		} else if (auctionForm.getCategory().equals("DOGS")) {
			pro_id = "P2P-DO-" + (product_seq);
		}else if (auctionForm.getCategory().equals("CATS")) {
			pro_id = "P2P-CA-" + (product_seq);
		}else if (auctionForm.getCategory().equals("REPTILES")) {
			pro_id = "P2P-RE-" + (product_seq);
		}else {
			pro_id = "P2P-BI-" + (product_seq);
		}
		System.out.println(pro_id);
		
		
		Product pro = new Product();
		
		pro.setProductId(pro_id);
		pro.setCategoryId(auctionForm.getCategory());
		
		pro.setName(auctionForm.getItemName());
		pro.setDescription(auctionForm.getAucDiscription());
				
		petStore.insertProduct(pro);	
		
		Item item = new Item();
		item.setItemId(id);
		item.setProductId(pro_id);
		item.setListPrice(auctionForm.getAuctionCost());
		item.setUnitCost(auctionForm.getAuctionCost());
		item.setStatus("P");
//		item.setAttribute1(file);
		item.setQuantity(1);
		
		petStore.insertItem(item);
		
		auction = new Auction();
		
		auction.setItemId(id);
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date endTime = transFormat.parse(request.getParameter("endDate"));

		auction.setEndtime(endTime);
		auction.setMaxPrice((int)item.getListPrice());
		auction.setAucStatus(false);
		auction.setAucName(auctionForm.getTitle());
		auction.setAuctionCost((int)item.getListPrice());
		auction.setUserId(username);
		auction.setAuction_num(1);
		auction.setItemName(auctionForm.getItemName());
		
		auctionService.insertAucItem(auction);
		
		return "tiles/AuctionItem";
	}
}