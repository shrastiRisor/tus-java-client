package io.tus.java.client;

import java.net.HttpCookie;
import java.net.URL;
import java.util.Set;

/**
 * Implementations of this interface are used to map an upload's fingerprint with the corresponding
 * upload URL. This functionality is used to allow resuming uploads. The fingerprint is usually
 * retrieved using {@link TusUpload#getFingerprint()}.
 */
public interface TusURLDetailStore {
    /**
     * Store a new fingerprint and its upload URL.
     *
     * @param fingerprint An upload's fingerprint.
     * @param urlDetail The corresponding upload URL.
     */
    void set(String fingerprint, URLDetail urlDetail);

    /**
     * Retrieve an upload's URL for a fingerprint. If no matching entry is found this method will
     * return <code>null</code>.
     *
     * @param fingerprint An upload's fingerprint.
     * @return The corresponding upload URL.
     */
    URLDetail get(String fingerprint);

    /**
     * Updates cookies for already stored fingerprint.
     *
     * @param fingerprint An upload's fingerprint.
     * @param cookies The corresponding upload cookies.
     */
    void updateCookies(String fingerprint, Set<HttpCookie> cookies);

    /**
     * Remove an entry from the store. Calling {@link #get(String)} with the same fingerprint will
     * return <code>null</code>. If no entry exists for this fingerprint no exception should be
     * thrown.
     *
     * @param fingerprint An upload's fingerprint.
     */
    void remove(String fingerprint);
}
