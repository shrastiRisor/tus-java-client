package io.tus.java.client;

import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test class for {@link TusURLMemoryDetailStore}.
 */
public class TestTusURLMemoryStore {

    /**
     * Tests if setting and deleting of an url in the {@link TusURLMemoryDetailStore} works.
     * @throws MalformedURLException
     */
    @Test
    public void test() throws MalformedURLException {
        TusURLDetailStore store = new TusURLMemoryDetailStore();
        URL url = new URL("https://tusd.tusdemo.net/files/hello");
        String fingerprint = "foo";
        store.set(fingerprint, new URLDetail(url, Collections.<HttpCookie>emptySet()));

        assertEquals(store.get(fingerprint).getUrl(), url);

        store.remove(fingerprint);

        assertNull(store.get(fingerprint));
    }
}
