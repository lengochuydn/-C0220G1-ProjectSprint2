package com.codegym.dao.repository;

import com.codegym.dao.DTO.AddressCount;
import com.codegym.dao.DTO.AgeCount;
import com.codegym.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {
    Page<User> findAllByDeleteFlagIsFalse(Pageable pageable);
    User findByAccount_AccountName(String accountName);

    @Query(value = "select user.address as 'addressUser',count(address) as 'counts' \n" +
            "from user \n" +
            "group by  address\n" +
            "order by count(address) desc limit 10;",nativeQuery = true)
    List<AddressCount> countAddress();

    @Query(value = "select `group`,count(*) as counts\n" +
            "from user\n" +
            "inner join (\n" +
            "select \n" +
            "(year(curdate())-2010) as `start` , (year(curdate()) - 2002) as `end`, 'Từ 10 đến 18 tuổi' as `group`\n" +
            "union all\n" +
            "select\n" +
            "(year(curdate())-2001) as `start`, (year(curdate())-1985) as `end`, 'Từ 19 đến 35 tuổi' as `group`\n" +
            "union all\n" +
            "select\n" +
            "(year(curdate())-1984) as `start`, (year(curdate())-1970) as `end`, 'Từ 36 đến 50 tuổi' as `group`\n" +
            "union all\n" +
            "select\n" +
            "(year(curdate())-1969) as `start`, (year(curdate())-1900) as `end`, 'Từ 51 tuổi đến 120 tuổi' as `group`\n" +
            ")`sub`\n" +
            "on timestampdiff(YEAR, `birthday`,NOW()) between `start` and `end`\n" +
            "group by `group` with rollup;",nativeQuery = true)
    List<AgeCount> countAge();
}
