package io.tus.java.client;

import java.net.HttpCookie;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class is used to map an upload's fingerprint with the corresponding upload URL by storing
 * the entries in a {@link HashMap}. This functionality is used to allow resuming uploads. The
 * fingerprint is usually retrieved using {@link TusUpload#getFingerprint()}.
 * <br>
 * The values will only be stored as long as the application is running. This store will not
 * keep the values after your application crashes or restarts.
 */
public class TusURLMemoryDetailStore implements TusURLDetailStore {
    private Map<String, URLDetail> store = new HashMap<String, URLDetail>();

    /**
     * Stores the upload's fingerprint and url.
     * @param fingerprint An upload's fingerprint.
     * @param urlDetail The corresponding upload URL.
     */
    @Override
    public void set(String fingerprint, URLDetail urlDetail) {
        store.put(fingerprint, urlDetail);
    }

    /**
     * Returns the corresponding Upload URL to a given fingerprint.
     * @param fingerprint An upload's fingerprint.
     * @return The corresponding upload URL.
     */
    @Override
    public URLDetail get(String fingerprint) {
        return store.get(fingerprint);
    }

    /**
     * Updates cookies for already stored fingerprint.
     *
     * @param fingerprint An upload's fingerprint.
     * @param cookies The corresponding upload cookies.
     */
    @Override
    public void updateCookies(String fingerprint, Set<HttpCookie> cookies) {
        URLDetail urlDetail = store.get(fingerprint);
        if (urlDetail != null) {
            urlDetail.getCookies().addAll(cookies);
        }
    }

    /**
     * Removes the corresponding entry to a fingerprint from the {@link TusURLMemoryDetailStore}.
     * @param fingerprint An upload's fingerprint.
     */
    @Override
    public void remove(String fingerprint) {
        store.remove(fingerprint);
    }
}
