package org.example.domain;

public class Report {
    private final Condition conditionalAction;
    private final Facts facts;
    private final boolean isPositive;

    public Report(final Facts facts, final Condition conditionalAction, final boolean isPositive) {
        this.facts = facts;
        this.conditionalAction = conditionalAction;
        this.isPositive = isPositive;
    }

    public Condition getConditionalAction() {
        return conditionalAction;
    }

    public Facts getFacts() {
        return facts;
    }

    public boolean isPositive() {
        return isPositive;
    }

    @Override
    public String toString() {
        return "Report{" +
                "conditionalAction=" + conditionalAction +
                ", facts=" + facts +
                ", result=" + isPositive +
                "}";
    }
}
