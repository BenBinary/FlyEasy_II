package fachlogik;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlugTest {

    @Test
    public void testToAndFrom() {
        Flug f1 = new Flug("20190101", Destinations.BER, Destinations.FRA, true);
        assertEquals(f1.getOrigin(), f1.getDestination());
    }

}