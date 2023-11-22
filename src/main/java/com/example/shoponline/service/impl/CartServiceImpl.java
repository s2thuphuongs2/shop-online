package com.example.shoponline.service.impl;

import com.example.shoponline.service.CartService;
import com.example.shoponline.util.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
	private final RedisTemplate<String, Object> redisTemplate;

	@Override
	public Boolean addProductToCart(Object object) {
		// fixme-done: \"org.springframework.security.core.Authentication.getPrincipal()\"
		// todo: Kiem tra Xac thuc truoc khi them sp vao Gio hang
		// todo: Thay the Authentication bang PreProduct ben Controller
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if(authentication != null && authentication.isAuthenticated()){
			String userId = AuthUtil.getUserId().toString();
			String cartRedisKey = userId.concat("_CART");
			redisTemplate.boundListOps(cartRedisKey).rightPush(object);
			return true;
//		} else {
//			// Xu ly khi khong tim thay thong tin xac thuc
//			return false;
//		}


	}

	@Override
	public List<Object> viewProductInCart() {
//		// fixme-done: \"org.springframework.security.core.Authentication.getPrincipal()\"
//		// todo: Kiem tra Xac thuc truoc khi xem Gio hang
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if(authentication != null && authentication.isAuthenticated()){
			String userId = AuthUtil.getUserId().toString();
			String cartRedisKey = userId.concat("_CART");
			BoundListOperations<String, Object> result = redisTemplate.boundListOps(cartRedisKey);
			return result.range(0, result.size());
//		} else {
//			// Xử lý khi không tìm thấy thông tin xác thực
//			return Collections.emptyList();
//		}

	}

	@Override
	public Boolean removeProductFromCart(Object object) {
		String userId = AuthUtil.getUserId().toString();
		String cartRedisKey = userId.concat("_CART");
		redisTemplate.boundListOps(cartRedisKey).remove(1, object);
		return true;
	}
}
