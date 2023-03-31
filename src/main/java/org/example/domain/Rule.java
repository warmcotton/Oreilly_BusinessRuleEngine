package org.example.domain;
@FunctionalInterface
public interface Rule {
    void perform(Facts facts);
}
