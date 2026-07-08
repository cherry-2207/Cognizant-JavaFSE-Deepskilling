package com.example;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public void processArg(String arg) {
        externalApi.doSomething(arg);
    }

    public void executeVoid() {
        externalApi.doSomethingVoid();
    }

    public void executeVoidWithException() throws Exception {
        externalApi.doSomethingVoidWithException();
    }
}