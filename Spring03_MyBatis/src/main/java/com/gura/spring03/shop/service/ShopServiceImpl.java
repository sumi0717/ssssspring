package com.gura.spring03.shop.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.shop.dao.OrderDao;
import com.gura.spring03.shop.dao.ShopDao;
import com.gura.spring03.shop.dto.OrderDto;
import com.gura.spring03.shop.dto.shopDto;

@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private OrderDao orderDao;
	@Override
	public void getList(ModelAndView mView) {
		//shopDoa 객체를 이용해서 상품 목록을 얻어와서
		List<shopDto> list=shopDao.getList();
		//인자로 전달된 ModelAndView 객체에 담는다
		//(request 영역에 담기 위해)
		mView.addObject("list",list);
		
	}
	@Override
	public void buy(HttpServletRequest request, ModelAndView mView) {
		//로그인 된 아이디
		String id=(String)request.getSession().getAttribute("id");
		//구입할 상품 번호
		int num = Integer.parseInt(request.getParameter("num"));
		
		//1. 상품의 가격정보 얻어오기
		int price=shopDao.getPrice(num);
		//2. 가격만큼 계좌 잔액을 줄인다
		shopDto dto=new shopDto();
		dto.setPrice(price);
		dto.setNum(num);
		dto.setId(id);
		shopDao.minusMoney(dto);
		//3. 가격의 10%를 포인트로 적립
		shopDao.plusPoint(dto);
		//4. 재고의 갯수를 -1 줄인다
		shopDao.minusCount(num);
		//5. 배송 요청 정보를 입력한다
		OrderDto orderDto=new OrderDto();
		orderDto.setCode(num);
		orderDto.setId(id);
		orderDto.setAddr("량량량");
		orderDao.addOrder(orderDto);
		
		
	}
}
