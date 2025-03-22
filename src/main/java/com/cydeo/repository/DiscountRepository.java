package com.cydeo.repository;

import com.cydeo.entity.Discount;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount,Long> {

    //Write a derived query to get all discounts greater than discount amount
    List<Discount> findAllByDiscountGreaterThan(BigDecimal discountIsGreaterThan);

    //Write a derived query to get all discounts by specific discount type
    List<Discount> findAllByDiscountType(DiscountType discountType);
    
    //Write a JPQL query to get all discounts with the discount amount between given range
    @Query(value="SELECT d FROM Discount d WHERE d.discount BETWEEN ?1 AND ?2")
    List<Discount> findAllByAmountRange(BigDecimal startAmount,BigDecimal endAmount);
}
