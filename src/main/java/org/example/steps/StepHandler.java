package org.example.steps;

//The "StepHandler" class is created in which the "Chain of Responsibility" design pattern is implemented,
// which is responsible for managing the test steps as a sequence of operations.
public abstract class StepHandler {
    private StepHandler next;

    public StepHandler linkWith(StepHandler next) {
        this.next = next;
        return next;
    }

    public void handle() {
        execute();
        if (next != null) {
            next.handle();
        }
    }

    protected abstract void execute();
}