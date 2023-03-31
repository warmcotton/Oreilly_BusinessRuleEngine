package org.example.engine;

import org.example.domain.*;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {

    // private final List<Action> actions;
    // private final List<Condition> conditions;

    private final List<Rule> rules;
    private final Facts facts;

    public BusinessRuleEngine(final Facts facts) {
        rules = new ArrayList<>();
        this.facts = facts;
    }

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public void addRule(Action action, Condition condition) {
        Rule rule = new DefaultRule(action,condition);
        this.rules.add(rule);
    }

//    public int count() {
//        return actions.size();
//    }

    public void run() {
        rules.forEach(rule -> {
            rule.perform(facts);
        });

        //rules.forEach(action -> action.perform(facts));
    }
}
