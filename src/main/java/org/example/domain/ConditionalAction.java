package org.example.domain;

public interface ConditionalAction {
    boolean evaluate(Facts facts);
    void perform(Facts facts);
}
