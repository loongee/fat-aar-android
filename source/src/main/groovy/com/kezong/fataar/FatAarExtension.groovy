package com.kezong.fataar;

import org.gradle.api.artifacts.Dependency

class FatAarExtension {

    /**
     * Used in RClassesTransform.java by reflection, don't change the name.
     */
    static final String NAME = "fataar"

    /**
     * If transitive is true, local jar module and remote library's dependencies will be embed. (local aar module does not support)
     * If transitive is false, just embed first level dependency
     * Default value is false
     * @since 1.3.0
     */
    boolean transitive = false
    
    /**
     * Internal storage for dependency configurations
     */
    final Map<String, EmbedDependencyConfig> dependencyConfigMap = new HashMap<>()
    
    /**
     * Configure a dependency with keepRawClasses setting
     * @param dependencyNotation The dependency notation (must be in "group:name:version" format)
     * @param keepRawClasses Whether to keep raw R classes for this dependency
     */
    void keepRawClasses(String dependencyNotation, boolean keepRawClasses = true) {
        EmbedDependencyConfig config = dependencyConfigMap.get(dependencyNotation)
        if (config == null) {
            config = new EmbedDependencyConfig()
            dependencyConfigMap.put(dependencyNotation, config)
        }
        config.keepRawClasses(keepRawClasses)
        println "[FatAar] Configured keepRawClasses=${keepRawClasses} for ${dependencyNotation}"
    }
}
