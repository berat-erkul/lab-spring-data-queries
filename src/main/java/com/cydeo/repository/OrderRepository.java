package com.cydeo.repository;

import com.cydeo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    //Write a derived query to get top 5 orders which are ordered by total price desc
    List<Order> findTop5ByOrderByTotalPriceDesc();

    //Write a derived query to check is there any orders by customer email
    boolean existsOrderByCustomerEmail(String email);

    //Write a JPQL query to get all orders that have equal totalPrice and paidPrice
    @Query(value="SELECT o FROM Order o WHERE o.totalPrice = o.paidPrice")
    List<Order> retrieveOrdersWithEqualTotalAndPaidPrice();

}
