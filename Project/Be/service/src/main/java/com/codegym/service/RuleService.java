package com.codegym.service;

import com.codegym.dao.entity.Rule;
import org.springframework.stereotype.Service;

import java.util.List;
public interface RuleService {
    List<Rule> findAllRule();

    Rule findRuleById(int id);
}
