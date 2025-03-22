package com.cydeo.repository;

import com.cydeo.entity.Cart;
import com.cydeo.entity.CartItem;
import com.cydeo.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    //Write a derived query to get the count of all cart items
    Integer countAllBy();

    //Write a derived query to get cart items for specific cart state
    List<Cart> findAllByCartState(CartState cartState);

    //Write a native query to get cart items for specific cart state and product name
    @Query(value="SELECT * FROM cart_item ci JOIN cart c ON ci.cart_id=c.id " +
                 "JOIN product p ON ci.product_id=p.id " +
                 "WHERE c.cart_state=?1 AND p.name=?2", nativeQuery = true)
    List<CartItem> retrieveCartItemsByCartStateAndProductName(CartState cartState, String Name);

    //Write a native query to get cart items for specific cart state and without discount
    @Query(value ="SELECT * FROM cart_item ci JOIN cart c " +
                  "ON ci.cart_id=c.id WHERE c.cart_state=?1 AND c.discount_id IS NULL", nativeQuery = true)
    List<CartItem> retrieveCartItemsByCartStateWithoutDiscount(String cartState);

}
