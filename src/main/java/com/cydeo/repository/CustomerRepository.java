package com.cydeo.repository;

import com.cydeo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    //Write a derived query to get customer by username
    Customer findByUserName(String username);

    //Write a JPQL query to get customer by email
    @Query(value="SELECT c FROM customer c WHERE c.email= :email", nativeQuery = true)
    Customer retrieveByCustomerEmail(@Param("email") String email);

}
