package com.codegym.dao.repository;

import com.codegym.dao.entity.AccessTimes;
import com.codegym.dao.DTO.AccessTimesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccessTimesRepository extends JpaRepository<AccessTimes, Integer> {

    //    @Query(value = "SELECT new  access_times.date, count(access_times.date) from access_times group by access_times.date",nativeQuery = true)
    @Query(value = "SELECT v.date as dates ,count(v.date) as counts FROM AccessTimes as v GROUP BY v.date")
    List<AccessTimesDTO> countAccessTimes();
}
