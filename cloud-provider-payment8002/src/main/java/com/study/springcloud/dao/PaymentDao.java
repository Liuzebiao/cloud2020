package com.study.springcloud.dao;

import com.study.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int create(Payment patment);

    public Payment getPaymentById(@Param("id") Long id);
}
