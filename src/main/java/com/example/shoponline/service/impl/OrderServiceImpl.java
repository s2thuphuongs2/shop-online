package com.example.shoponline.service.impl;

import com.example.shoponline.customenum.OrderStatus;
import com.example.shoponline.dto.order.OrderDTO;
import com.example.shoponline.entity.OrderEntity;
import com.example.shoponline.entity.ProductEntity;
import com.example.shoponline.entity.UserEntity;
import com.example.shoponline.exception.BusinessException;
import com.example.shoponline.repository.OrderRepository;
import com.example.shoponline.repository.ProductRepository;
import com.example.shoponline.repository.UserRepository;
import com.example.shoponline.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public OrderEntity createOrder(OrderDTO orderRequest) {
        return null;
    }
    //DONE - CHECK OUT ORDER
    @Override
    public OrderEntity checkoutOrder(OrderDTO orderDto) {
        // Lấy thông tin người dùng từ cơ sở dữ liệu
        UserEntity userEntity = userRepository.findById(orderDto.getUserId())
                .orElseThrow(() -> new BusinessException("USER_NOT_FOUND", "Người dùng không tồn tại"));

        // Lấy danh sách sản phẩm từ cơ sở dữ liệu
        List<ProductEntity> products = productRepository.findAllById(orderDto.getProductIds());

        // Tạo đơn hàng mới
        OrderEntity newOrder = new OrderEntity();
        newOrder.setUser(userEntity);
        newOrder.setProducts(products);
        newOrder.setShippingInfo(orderDto.getShippingInfo());
        newOrder.setStatus(OrderStatus.PENDING); // Mặc định đơn hàng có trạng thái chờ xác nhận
        newOrder.setTotalPrice(orderDto.getTotalAmount());

        // Các bước khác để thiết lập thông tin đơn hàng
        newOrder.setPaymentMethod(orderDto.getPaymentMethod());
        newOrder.setDeliveryNote(orderDto.getDeliveryNote());
        // ...

        // Lưu đơn hàng mới vào cơ sở dữ liệu
        OrderEntity savedOrder = orderRepository.save(newOrder);

        return savedOrder;
    }

    @Override
    public OrderDTO mapOrderEntityToDto(OrderEntity orderEntity) {
        return null;
    }
//TODO - calculate total price
    private BigDecimal calculateTotalPrice(List<ProductEntity> products) {
        // Thực hiện tính toán tổng giá tiền của các sản phẩm trong đơn hàng
        // (Cần cài đặt logic tính toán tổng giá tiền dựa trên giá của sản phẩm)
        // ...

        return BigDecimal.ZERO; // Đây là giá trị mẫu, cần cài đặt logic tính toán thực tế
    }
}
