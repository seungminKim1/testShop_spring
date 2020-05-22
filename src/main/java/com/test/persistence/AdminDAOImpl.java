package com.test.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.test.domain.CategoryVO;
import com.test.domain.GoodsVO;
import com.test.domain.GoodsViewVO;
import com.test.domain.MemberVO;
import com.test.domain.OrderListVO;
import com.test.domain.OrderVO;
import com.test.domain.ReplyListVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Inject
	public SqlSession sql;
	
	//매퍼
	private static String namespace = "com.test.mappers.adminMapper"; 
	
	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".category");
	}
	//상품등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".register",vo);
		
	}
	//상품목록
	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".goodslist");
	}
	//상품조회 + 카테고리 조인
	@Override
	public GoodsViewVO goodsview(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".goodsview",gdsNum);
	}
	
	//상품수정
	@Override
	public void goodsmodify(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace+".goodsmodify",vo);
		
	}
	
	//상품삭제
	@Override
	public void goodsdelete(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		sql.delete(namespace + ".goodsdelete",gdsNum);
	}
	//주문 목록
	@Override
	public List<OrderVO> orderList() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".orderList");
	}
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".orderView",order);
	}
	@Override
	public void delivery(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace + ".delivery",order);
	}
	@Override
	public void chageStock(GoodsVO goods) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace + ".changeStock" ,goods);
	}
	@Override
	public List<ReplyListVO> allReply() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".allReply");
	}
	@Override
	public int deleteReply(int repNum) throws Exception {
		// TODO Auto-generated method stub
		return sql.delete(namespace + ".deleteReply",repNum);
	}
	
	//회원 목록
	@Override
	public List<MemberVO> memberList() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".memberList");
	}
	
}
