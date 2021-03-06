package com.example.jpetstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpetstore.dao.QADao;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.QA;

@Service
public class QAServiceImpl implements QAService {

	@Autowired
	private QADao qaDao;
	
	@Override
	public void insertQA(QA qa) {
		// TODO Auto-generated method stub
		qaDao.insertQAPost(qa);
	}
	@Override
	public void insertQASeller(QA qa) {
		qaDao.insertQASellerPost(qa);
	}
	
	@Override
	public void deleteQAPost(int qnum) {
		// TODO Auto-generated method stub
		qaDao.deleteQAPost(qnum);
	}

	@Override
	public void updateQA(QA qa) {
		// TODO Auto-generated method stub
		qaDao.updateQAPost(qa);
	}

	@Override
	public List<QA> getQAList() {
		// TODO Auto-generated method stub
		return qaDao.getQAList();
	}
	
	@Override
	public QA getQA(int qaNum) {
		return qaDao.getQA(qaNum);
	}

	@Override
	public void insertQAReply(QA qa) {
		qaDao.insertQAReply(qa);
	}
}
