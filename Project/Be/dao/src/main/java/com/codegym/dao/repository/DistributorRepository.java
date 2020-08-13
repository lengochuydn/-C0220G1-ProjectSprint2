package com.codegym.dao.repository;

import com.codegym.dao.entity.Distributor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DistributorRepository extends JpaRepository<Distributor, Integer> {

    Page<Distributor> findAllByNameContainingAndDeletedIsFalseOrAddressContainingAndDeletedIsFalse(Pageable pageable,String name,String address);
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Distributor u set u.deleted = ?1 where u.id = ?2")
    void delete(boolean isDeleted, Integer id);

    List<Distributor> findAllByDeleted(boolean isNotDeleted);
}
