package com.nd.mvpcore.util;

import android.support.annotation.Nullable;

/**
 * Created by liy on 2015/8/25.
 */
public class Preconditions {

    public static void checkState(boolean expression, @Nullable Object errorMessage) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    public static void checkArgument(boolean expression, @Nullable Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }
}
