package com.lt.business;

import java.util.List;

import com.lt.bean.Payment;

public interface PaymentInterface {
public void generateBill(Payment pay);

public List<Payment> printBill();

public String paymentStatus();

//public void addCard(CardDetails cd);
public void addBanking();

public void doPayment();

}
