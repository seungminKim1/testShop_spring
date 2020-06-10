package com.test.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.test.domain.CategoryVO;
import com.test.domain.GoodsVO;
import com.test.domain.GoodsViewVO;
import com.test.domain.MemberVO;
import com.test.domain.OrderListVO;
import com.test.domain.OrderVO;
import com.test.domain.ReplyListVO;
import com.test.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Inject
	private AdminDAO dao;
	
	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		// TODO Auto-generated method stub
		return dao.category();
	}
	
	//상품등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.register(vo);
	}
	
	//상품목록
	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		// TODO Auto-generated method stub
		return dao.goodslist();
	}
	
	//상품수정 + 카테고리 조인
	@Override
	public GoodsViewVO goodsview(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.goodsview(gdsNum);
	}
	
	
	//상품수정
	@Override
	public void goodsmodify(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.goodsmodify(vo);
	}
	
	//상품삭제
	@Override
	public void goodsdelete(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		dao.goodsdelete(gdsNum);
	}
	
	//주문 목록
	@Override
	public List<OrderVO> orderList() throws Exception {
		// TODO Auto-generated method stub
		return dao.orderList();
	}
	
	
	//특정 주문 목록
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
		return dao.orderView(order);
	}
	
	//배송상태
	@Override
	public void delivery(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
		dao.delivery(order);
	}
	
	//상품 수량 조절
	@Override
	public void changeStock(GoodsVO goods) throws Exception {
		// TODO Auto-generated method stub
		dao.chageStock(goods);
	}

	@Override
	public List<ReplyListVO> allReply() throws Exception {
		// TODO Auto-generated method stub
		return dao.allReply();
	}

	@Override
	public int deleteReply(int repNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteReply(repNum);
	}

	@Override
	public List<MemberVO> memberList() throws Exception {
		// TODO Auto-generated method stub
		return dao.memberList();
	}

	@Override
	public int countGoods() throws Exception {
		// TODO Auto-generated method stub
		return dao.countGoods();
	}
	

}
