package org.example.engine;

import org.example.domain.Condition;
import org.example.domain.ConditionalAction;
import org.example.domain.Facts;
import org.example.domain.Report;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inspector {
    private final List<Condition> conditionalActionList;

    public Inspector(final Condition conditionalAction) {
        this.conditionalActionList = Arrays.asList(conditionalAction);
    }

    public List<Report> inspect(final Facts facts) {
        final List<Report> reportList = new ArrayList<>();
        for(Condition conditionalAction : conditionalActionList) {
            final boolean conditionResult = conditionalAction.evaluate(facts);
            reportList.add(new Report(facts, conditionalAction, conditionResult));
        }
        return reportList;
    }
}
