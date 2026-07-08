package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {
    @Test
    public void testExternalApi() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.processArg("test");
        verify(mockApi).doSomething(anyString());
    }

    @Test
    public void testHandlingVoidMethods() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doNothing().when(mockApi).doSomethingVoid();
        MyService service = new MyService(mockApi);
        service.executeVoid();
        verify(mockApi).doSomethingVoid();
    }

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("First").thenReturn("Second");
        MyService service = new MyService(mockApi);
        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
    }

    @Test
    public void testVerifyInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        service.executeVoid();
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).doSomethingVoid();
    }

    @Test
    public void testVoidMethodWithExceptions() throws Exception {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new RuntimeException("Error")).when(mockApi).doSomethingVoidWithException();
        MyService service = new MyService(mockApi);
        assertThrows(RuntimeException.class, () -> {
            service.executeVoidWithException();
        });
    }
}