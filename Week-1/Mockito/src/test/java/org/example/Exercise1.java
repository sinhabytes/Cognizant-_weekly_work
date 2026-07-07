package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Exercise1 {

    @Test
    void testExternalApi() {

        // Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub the method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Create service
        MyService service = new MyService(mockApi);

        // Call method
        String result = service.fetchData();

        // Verify result
        assertEquals("Mock Data", result);
    }
}