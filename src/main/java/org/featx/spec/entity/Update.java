package org.featx.spec.entity;

import java.time.LocalDateTime;

/**
 * Some domain data structure which would be update
 *
 * @param <I>
 * @author Excepts
 */
interface Update<I> extends Record<I> {
    /**
     * Get update  date time
     *
     * @return the date time
     */
    LocalDateTime getUpdatedAt();
}