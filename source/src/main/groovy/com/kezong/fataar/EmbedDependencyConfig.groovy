package com.kezong.fataar

/**
 * Configuration for embed dependencies
 * Simple holder for keepRawClasses flag
 */
class EmbedDependencyConfig {
    private boolean keepRawClasses = false

    void keepRawClasses(boolean value) {
        this.keepRawClasses = value
    }

    boolean getKeepRawClasses() {
        return keepRawClasses
    }
}

