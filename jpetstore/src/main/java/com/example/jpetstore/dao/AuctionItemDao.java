package com.example.jpetstore.dao;

import java.util.List;

import com.example.jpetstore.domain.Auction;

public interface AuctionItemDao {
	
	void insertAucItem(Auction auction);
	void updateAucStatus(int aucNum, boolean aucStatus);
	void updateAucItem(Auction auction);
	List<Auction> getAuctionList();
	
	void insertPrice(Auction auction);
//	void insertPrice(int auction_Num, int inputPrice, String userID);

	void updateOrderStatus(int aucNum, boolean orderStatus);
	int auctionListSize();
	
	String findAucUserID(int aucNum);
	void deleteMaxPrice(int acuNum);
	
	Auction getAuctionDetail(int aucNum);
	
}
