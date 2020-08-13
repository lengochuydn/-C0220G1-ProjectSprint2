package com.codegym.service.impl;

import com.codegym.dao.entity.Rule;
import com.codegym.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RuleServiceImpl implements RuleService {
    @Autowired
    private com.codegym.dao.repository.RuleRepository ruleRepository;

    @Override
    public List<Rule> findAllRule() {
        return ruleRepository.findAll();
    }

    @Override
    public Rule findRuleById(int id) {
        return ruleRepository.findById(id).orElse(null);
    }
}
