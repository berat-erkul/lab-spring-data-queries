package com.cydeo.repository;

import com.cydeo.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance, Long> {

    //Write a native query to get top 5 max balance
    @Query(value="SELECT * FROM balance ORDER BY amount DESC LIMIT 5",nativeQuery = true)
    List<Balance> retrieveTop5Amount();

    //Write a derived query to get all balances greater than or equal to specific balance amount
    List<Balance> findAllByAmountGreaterThanEqual(BigDecimal amount);

    //Write a native query to get all balances less than specific balance amount
    @Query(value="SELECT * FROM balance WHERE amount < ?1", nativeQuery = true)
    List<Balance> retrieveBalanceLessThanAmount(BigDecimal amount);
}
