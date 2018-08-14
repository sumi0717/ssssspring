package com.gura.spring03.shop.dao;

import java.util.List;

import com.gura.spring03.shop.dto.shopDto;

public interface ShopDao {
	public List<shopDto> getList(); //상품 목록을 리턴시켜주는 메소드
	public void minusCount(int num); //상품 재고를 감소 시키는 메소드
	public void minusMoney(shopDto dto); //잔고 감소
	public void plusPoint(shopDto dto); //포인트 증가
	public int getPrice(int num);// 상품 가격을 리턴해주는 메소드
}
