package com.test.service;

import java.util.List;

import com.test.domain.CategoryVO;
import com.test.domain.GoodsVO;
import com.test.domain.GoodsViewVO;
import com.test.domain.MemberVO;
import com.test.domain.OrderListVO;
import com.test.domain.OrderVO;
import com.test.domain.ReplyListVO;

public interface AdminService {
	
	//카테고리
	public List<CategoryVO> category() throws Exception;
	
	//상품 등록
	public void register(GoodsVO vo) throws Exception;
	
	//상품목록 
	public List<GoodsViewVO> goodslist() throws Exception;
	
	//상품조회
	public GoodsViewVO goodsview(int gdsNum) throws Exception;
	
	//상품수정
	public void goodsmodify(GoodsVO vo) throws Exception;
	
	//상품삭제
	public void goodsdelete(int gdsNum) throws Exception;
	
	//주문 목록
	public List<OrderVO> orderList() throws Exception;
	
	//특정 주문 목록
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
	
	//배송상태
	public void delivery(OrderVO order) throws Exception;
	
	//상품 수량 조절
	public void changeStock(GoodsVO goods) throws Exception;
	
	// 모든 소감(댓글)
	public List<ReplyListVO> allReply() throws Exception;
	
	//소감 (댓글) 삭제
	public int deleteReply(int repNum) throws Exception;
	
	//회원 목록
	public List<MemberVO> memberList() throws Exception; 
}
