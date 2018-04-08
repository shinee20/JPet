package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Order;

public interface ItemDao {

  public void updateQuantity(Order order) throws DataAccessException;

  boolean isItemInStock(String itemId) throws DataAccessException;

  List<Item> getItemListByProduct(String productId) throws DataAccessException;

  Item getItem(String itemId) throws DataAccessException;
  
  void updateQuantity(int itemId) throws DataAccessException;
  //주문 취소로 인한 수량 변화가 발생하였을 때 사용하는 메소드 

}
