package com.cydeo.repository;

import com.cydeo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long>{

    //Write a derived query to get all addresses starting with a street name
    List<Address> findAllByStreetStartingWith(String street);

    //Write a derived query to get top 3 addresses with a specific customer email
    List<Address> findTop3ByCustomer_Email(String email);

    //Write a JPQL query to get all addresses with a specific customerId
    @Query("SELECT e FROM Address e WHERE e.customer.id = ?1")
    List<Address> retrieveByCustomerId(Long id);
}
