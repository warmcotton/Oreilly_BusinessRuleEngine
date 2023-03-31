package org.example.domain;
@FunctionalInterface
public interface Condition {
    boolean evaluate(Facts facts);
}
