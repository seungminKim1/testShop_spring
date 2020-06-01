# testShop
 Shopping mall with Spring
# Info
* Language
  * Java,Jsp,Javascript,html,JQuery,Ajax
* Framework  
  * SPRING
* DB
  * Oracle
* 이미지 및 흐름 (기능)
![main](https://github.com/seungminKim1/testShop/blob/master/testShop_port/user/유저메인.PNG)
![main](https://github.com/seungminKim1/testShop/blob/master/testShop_port/admin/관리자%20메인0.PNG)
 로그인 후 메인화면의 모습 *유저* 가 접근할수있는 메뉴와 **관리자**의 메뉴가 다르다.
![regist](https://github.com/seungminKim1/testShop/blob/master/testShop_port/admin/관리자%20상품%20등록%201.PNG)
 **관리자**가 이미지를 업로드 후 상품을 등록시
![registResult](https://github.com/seungminKim1/testShop/blob/master/testShop_port/admin/관리자%20상품%20목록%202.PNG)
 썸네일 이미지가 자동 생성되어 등록된 상품을 목록에서 볼수 있다.
![goodsList](https://github.com/seungminKim1/testShop/blob/master/testShop_port/user/유저%20상품%20목록.PNG)
 *유저* 화면에서의 등록된 상품 목록
![goodsView](https://github.com/seungminKim1/testShop/blob/master/testShop_port/user/유저%20상품%20상세보기.PNG)
 상품을 클릭하면 상품 상세보기 창으로 이동하고 *유저*는 상품평 남기기 및 장바구니에 상품을 담을수 있다.
 ![goodsReply](https://github.com/seungminKim1/testShop/blob/master/testShop_port/user/유저%20상품평.PNG)
 등록된 상품평들
 ![Cart](https://github.com/seungminKim1/testShop/blob/master/testShop_port/user/유저%20카트.PNG)
  *유저* 가 상품의 수량을 선택 후 카드에 담은 모습
 ![CartAdress](https://github.com/seungminKim1/testShop/blob/master/testShop_port/user/유저%20배송정보%20입력.PNG)
  *유저* 는 자신의 배송지 주소를 입력해 주문을 한다. (배송지 주소를 입력 받는 부분은 카카오 주소 API 사용)
 ![orderList](https://github.com/seungminKim1/testShop/blob/master/testShop_port/user/유저%20주문%20목록.PNG)
  성공적으로 주문 완료된 모습
 ![orderView](https://github.com/seungminKim1/testShop/blob/master/testShop_port/user/유저%20주문%20상세보기.PNG)
  주문 상세보기를 통해 *유저* 가 주문한 상품,배송지,현재 배송상태를 볼 수 있다. 
 ![adOrderList](https://github.com/seungminKim1/testShop/blob/master/testShop_port/admin/관리자%20주문%20목록%203.PNG)
  *유저* 가 주문한 주문을 **관리자**가 확인한 모습
 ![adOrderView](https://github.com/seungminKim1/testShop/blob/master/testShop_port/admin/관리자%20주문%20상세보기%20및%20배송%20관리%204.PNG)
  출고가 완료된 주문에 대해서는 **관리자**가 상품의 배송 상태를 변경해 줄수 있다.
 ![adOrderChange](https://github.com/seungminKim1/testShop/blob/master/testShop_port/admin/배송%20상태%20변경%205.PNG)
  배송상태가 변경된 주문들의 모습 (배송 완료가 되면 상품의 수량이 자동 감소 된다)
 ![adGoodsSO](https://github.com/seungminKim1/testShop/blob/master/testShop_port/admin/관리자%20배송%20완료%20후%20품절%206.PNG) 
  상품의 재고가 부족해 품절이 된 모습
 ![adReplyList](https://github.com/seungminKim1/testShop/blob/master/testShop_port/admin/관리자%20상품평%20목록%207.PNG) 
  **관리자**는 상품에 대한 상품평을 관리 할 수있다.
 ![adMemberList](https://github.com/seungminKim1/testShop/blob/master/testShop_port/admin/관리자%20회원%20목록%208.PNG)
 **관리자**는 전체 회원목록을 볼 수있다.
 ![adMemberPass](https://github.com/seungminKim1/testShop/blob/master/testShop_port/admin/회원%20비밀번호%20암호화%20관리%209.PNG)
  회원 가입시 비밀번호는 spring-security를 통해 암호화 되어 저장된다.
  
 ------
 * 
   * 
