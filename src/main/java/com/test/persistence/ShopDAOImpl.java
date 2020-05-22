package com.test.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.test.domain.CartListVO;
import com.test.domain.CartVO;
import com.test.domain.GoodsViewVO;
import com.test.domain.OrderDetailVO;
import com.test.domain.OrderListVO;
import com.test.domain.OrderVO;
import com.test.domain.ReplyListVO;
import com.test.domain.ReplyVO;

@Repository
public class ShopDAOImpl implements ShopDAO {

	@Inject
	public SqlSession sql;
	
	//매퍼
	private static String namespace = "com.test.mappers.shopMapper";
	
	//카테고리별 상품 리스트 : 1차분류
	@Override
	public List<GoodsViewVO> list(int cateCode,int cateCodeRef) throws Exception {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		
		map.put("cateCode",cateCode);
		map.put("cateCodeRef",cateCodeRef);
		
		return sql.selectList(namespace + ".list_1",map);
	}
	
	//카테고리별 상품 리스트 : 2차분류
	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".list_2",cateCode);
	}

	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("com.test.mappers.shopMapper" + ".goodsView",gdsNum);
	}

	@Override
	public void registReply(ReplyVO reply) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".registReply",reply);
	}

	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".replyList",gdsNum);
	}

	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		// TODO Auto-generated method stub
		sql.delete(namespace + ".deleteReply",reply);
	}

	@Override
	public String idCheck(int repNum) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".replyUserIdCheck",repNum);
	}

	//상품 소감(댓글) 수정
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace+ ".modifyReply",reply); 
	}
	
	//카트 담기
	@Override
	public void addCart(CartVO cart) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".addCart",cart);
	}
	
	//카트리스트
	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".cartList",userId);
	}

	@Override
	public void deleteCart(CartVO cart) throws Exception {
		// TODO Auto-generated method stub
		sql.delete(namespace + ".deleteCart",cart);
	}

	@Override
	public void orderInfo(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".orderInfo",order);
	}

	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".orderInfo_Details",orderDetail);
	}

	@Override
	public void cartAllDelete(String userId) throws Exception {
		// TODO Auto-generated method stub
		sql.delete(namespace + ".cartAllDelete",userId);
	}

	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".orderList",order);
	}

	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".orderView",order);
	}

}
