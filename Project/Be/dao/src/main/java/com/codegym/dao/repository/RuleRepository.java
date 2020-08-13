package com.codegym.dao.repository;

import com.codegym.dao.entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, Integer> {
}
