package org.example.strategy;

//The Strategy Pattern is implemented in the strategy package with the "ExecutionStrategy" interface.
// This allows you to define multiple ways to perform a login and dynamically choose one at runtime.
public interface ExecutionStrategy {
    void login(String email, String password);
}
