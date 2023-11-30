package com.example.shoponline.controller;

import com.example.shoponline.dto.api.ResponseDto;
import com.example.shoponline.dto.order.OrderDTO;
import com.example.shoponline.entity.OrderEntity;
import com.example.shoponline.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
//@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderRequest) {
        try {
            // Lấy thông tin đơn hàng từ request và xác thực người dùng (nếu cần)
            // ...

            // Thực hiện tạo đơn hàng
            OrderEntity order = orderService.createOrder(orderRequest);

            // Trả về thông tin đơn hàng đã tạo
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            // Xử lý lỗi và trả về phản hồi lỗi
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating order: " + e.getMessage());
        }
    }
    //TODO - check out order
    @PostMapping("/checkout")
    public ResponseDto<OrderEntity> checkoutOrder(@RequestBody OrderDTO orderDto) {
        OrderEntity checkedOutOrder = orderService.checkoutOrder(orderDto);
        return ResponseDto.ok(checkedOutOrder);
    }
}

