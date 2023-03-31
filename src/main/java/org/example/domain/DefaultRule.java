package org.example.domain;

public class DefaultRule implements Rule{
    private final Action action;
    private final Condition condition;

    public DefaultRule(Action action, Condition condition) {
        this.action = action;
        this.condition = condition;
    }

    public Action getAction() {
        return action;
    }

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void perform(Facts facts) {
        if(condition.evaluate(facts)) action.perform(facts);
    }
}
