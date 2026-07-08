package com.example;

public interface ExternalApi {
    String getData();
    void doSomething(String arg);
    void doSomethingVoid();
    void doSomethingVoidWithException() throws Exception;
}