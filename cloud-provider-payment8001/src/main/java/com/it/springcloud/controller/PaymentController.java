package com.it.springcloud.controller;

import com.it.springcloud.entity.CommonResult;
import com.it.springcloud.entity.Payment;
import com.it.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    /**
     * 只传给前端CommonResult，不需要前端了解其他的组件
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if(result > 0){
            return new CommonResult(200, "插入数据成功", result);
        }else{
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    /**
     * http://localhost:8001/payment/get/32
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****得到结果："+payment);
        if(payment != null){
            return new CommonResult(200, "查询成功", payment);
        }else{
            return new CommonResult(444, "没有对应记录,查询ID："+id, null);
        }
    }
}
