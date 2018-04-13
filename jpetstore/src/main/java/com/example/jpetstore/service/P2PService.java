package com.example.jpetstore.service;

public interface P2PService {
	//p2p

	void insertItem(Item item);
	//�Ǹ��ڰ� �ۼ��� p2p�� �ִ� item ������ �����Ѵ�. 

	void insertP2P(P2P p2p);
	//����ڰ� �Է��� p2p post�� ������ �����Ѵ�. 

	//void updateQuantity(int itemId, int quantity);
	//����ڰ� �ֹ�/ �ֹ���� ���� ��� item�� ������ �����Ѵ�. 

	P2P getP2PList(String userId);
	//userId�� �´� p2p����Ʈ�� �޾ƿͼ� �Ǹ����������� �����Ѵ�. 

	Item getItem(String itemId, String userId); 
	//userId�� ������ �Ǹ��� �������� �����´�. 

	void deleteItem(int itemId);
	//cascade�� �̿��ؼ� ����� p2p�� �����. 

	void updateP2P(Item itemId);
	//�Ǹ��ڰ� ������ ������ �����Ͽ��� ��� ȣ��ȴ�. 

}