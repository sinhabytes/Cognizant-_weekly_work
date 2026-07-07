package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class Exercise2 {

    @Test
    void testVerifyInteraction() {

        // Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Create service
        MyService service = new MyService(mockApi);

        // Call the method
        service.fetchData();

        // Verify that getData() was called exactly once
        verify(mockApi).getData();
    }
}