package org.example.domain;

@FunctionalInterface
public interface Action {
    void perform(Facts facts);
}
