package com.test.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.test.domain.CategoryVO;
import com.test.domain.GoodsVO;
import com.test.domain.GoodsViewVO;
import com.test.domain.MemberVO;
import com.test.domain.OrderListVO;
import com.test.domain.OrderVO;
import com.test.domain.ReplyListVO;
import com.test.service.AdminService;
import com.test.utils.UploadFileUtils;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static Logger Logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	//servlet-context.xml 에서 설정한 uploadPath
	
	//관리자 화면
	@RequestMapping(value="/index",method= RequestMethod.GET)
	public void getIndex() throws Exception{
		Logger.info("get index");		
	}
	
	//상품 등록
	@RequestMapping(value="/goods/register", method=RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception{
		Logger.info("get goods register");
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category",JSONArray.fromObject(category));
	}
	
	//상품등록
	@RequestMapping(value="/goods/register", method=RequestMethod.POST)
	public String postGoodsRegister(GoodsVO vo, MultipartFile file) throws Exception{
		Logger.info("post goods register");	
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		// 이미지를 업로드할 폴더를 설정 = /uploadPath/imgUpload
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		// 위의 폴더를 기준으로 연월일 폴더를 생성
		String fileName = null;
		//기본 경로와 별개로 작성되는 경로 + 파일이름
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			//파일 인풋박스에 첨부된 파일이 없다면 (=첨부된 파일이 이름이 없다면)
			
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			// gdsImg에 원본 파일 경로 + 파일명 저장
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
			//gdsThumbImg에 썸네일 파일 경로 + 썸네일 파일명 저장
			
		} else {
			fileName = File.separator + "images" + File.separator + "none.png";
			//미리 준비된 none.png파일을 대신 출력함
			
			vo.setGdsImg(fileName);
			vo.setGdsThumbImg(fileName);
		}
		
		adminService.register(vo);
		
		return "redirect:/admin/index";
	}
	
	//상품목록
	@RequestMapping(value="/goods/list", method=RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception{
		Logger.info("get goods list");
		
		List<GoodsViewVO> list = adminService.goodslist();
	
		model.addAttribute("list", list);
	}
	
	//ck에디터에서 파일 업로드
	@RequestMapping(value="/goods/ckUpload", method=RequestMethod.POST)
	public void postCKEditorImgUpload(HttpServletRequest req,
									  HttpServletResponse res,
									  @RequestParam MultipartFile upload) throws Exception {
		Logger.info("post CKEditor img upload");
		
		//랜덤 문자 생성
		UUID uid = UUID.randomUUID();
		
		OutputStream out = null;
		PrintWriter printWriter = null;
		
		//인코딩
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		try {
			//파일 이름 가져오기
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();			
			
			//업로드 경로
			String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "-" + fileName;
			
			out= new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			// out에 저장된 데이터를 전송하고 초기화
			out.flush();
			
//			String callback = req.getParameter("CKEditorFuncNum");
			printWriter = res.getWriter();
			String fileUrl = "/ckUpload/" + uid + "-" + fileName; //작성화면
					
			printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
			
			//업로드시 메시지 출력	
//			printWriter.println("<script type='text/javascript'>"
//					+ "window.parent.CKEDITOR.tools.callFunction("
//					+ callback +",'"+ fileUrl +"','이미지를 업로드하였습니다. ')"
//					+ "</script>");
			
			printWriter.flush();
			
		} catch (IOException e) {e.printStackTrace();
		} finally {
			try {
				if(out != null) {out.close();}
				if(printWriter != null) {printWriter.close();}
			} catch (IOException e) {e.printStackTrace();}
		}
		
		return;
	}
	
	//상품조회
	@RequestMapping(value="/goods/view", method=RequestMethod.GET)
	public void getGoodsView(@RequestParam("n") int gdsNum,Model model) throws Exception {
		Logger.info("get goods view");
		
		GoodsViewVO goods = adminService.goodsview(gdsNum);
		
		model.addAttribute("goods", goods);
	}
	
	//상품 수정
	@RequestMapping(value="/goods/modify",method=RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int gdsNum,Model model) throws Exception {
		Logger.info("get goods modify");
		
		GoodsViewVO goods = adminService.goodsview(gdsNum);
		model.addAttribute("goods",goods);
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));	
	}
	
	//상품수정
	@RequestMapping(value="/goods/modify", method=RequestMethod.POST)
	public String postGoodsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws Exception {
		Logger.info("post goods modify");
		
		//새로운 파일이 등록되었는지 확인
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			
			//기존 파일 삭제
			new File(uploadPath + req.getParameter("gdsImg")).delete();
			new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
			
			//새로 첨부한 파일을 등륵
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		} else {//새로운 파일이 등록되지 않았다면
			//기존 이미지를 그대로 사용
			vo.setGdsImg(req.getParameter("gdsImg"));
			vo.setGdsThumbImg("gdsThumbImg");
			
		}
		
		
		adminService.goodsmodify(vo);
		
		return "redirect:/admin/goods/list";
	}
	
	//상품삭제	
	@RequestMapping(value="/goods/delete", method=RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception {
		Logger.info("post goods delete");
		
		adminService.goodsdelete(gdsNum);
		
		return "redirect:/admin/goods/list";
	}
	
	//주문 목록
	@RequestMapping(value="/shop/orderList", method = RequestMethod.GET)
	public void getOrderList(Model model) throws Exception {
		Logger.info("get order list");
		
		List<OrderVO> orderList = adminService.orderList();
		
		model.addAttribute("orderList",orderList);
	}
	
	//주문 상세 목록
	@RequestMapping(value="/shop/orderView", method = RequestMethod.GET)
	public void getOrderList(@RequestParam("n") String orderId,
							 OrderVO order, Model model) throws Exception {
		Logger.info("get order view");
		
		order.setOrderId(orderId);
		List<OrderListVO> orderView = adminService.orderView(order);
		
		model.addAttribute("orderView",orderView);
	}
	
	//주문 상세목록 - 상태 변경
	@RequestMapping(value="/shop/orderView", method = RequestMethod.POST)
	public String delivery(OrderVO order) throws Exception {
		Logger.info("post delivery");
		
		adminService.delivery(order);
		
		List<OrderListVO> orderView = adminService.orderView(order);
		GoodsVO goods = new GoodsVO();
		
		for(OrderListVO i : orderView) {
			goods.setGdsNum(i.getGdsNum());
			goods.setGdsStock(i.getCartStock());
			adminService.changeStock(goods);
		}
		
		
		return "redirect:/admin/shop/orderList"; 
	}
	
	// 모든 소감(댓글)
	@RequestMapping(value="/shop/allReply", method = RequestMethod.GET)
	public void getAllReply(Model model) throws Exception {
		Logger.info("get all reply");
		
		List<ReplyListVO> reply = adminService.allReply();
		
		model.addAttribute("reply",reply);
	}
	
	//댓글 삭제
	@ResponseBody
	@RequestMapping(value="/shop/deleteReply", method = RequestMethod.POST)
	public int postDeleteReply(@RequestParam(value = "repNum") int repNum  ) throws Exception {
		Logger.info("post delete reply");
		
		int result = 0;
		
		result = adminService.deleteReply(repNum);
		
		return result;
		
	}
	
	//회원 목록
	@RequestMapping(value="/member/memberList", method = RequestMethod.GET)
	public void getMemberList(Model model) throws Exception {
		Logger.info("get member list");
		
		List<MemberVO> memberList = adminService.memberList();
		
		model.addAttribute("memberList",memberList);
		
	}
}
