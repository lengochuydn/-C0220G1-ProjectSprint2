package com.codegym.dao.repository;

import com.codegym.dao.DTO.BuyCount;
import com.codegym.dao.entity.Order;
import com.codegym.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query(value = "select u from Order u where u.user.id=?1")
    Page<Order> findAllByIdUser(Integer id, Pageable pageable);

    @Query(value = "select user.user_name as 'nameUser', count(order_user.id_user) as 'counts'\n" +
            "from order_user inner join user on order_user.id_user = user.id_user\n" +
            "group by  order_user.id_user\n" +
            "order by count( order_user.id_user) desc limit 10;",nativeQuery = true)
    List<BuyCount> getBuyCounts();
}
