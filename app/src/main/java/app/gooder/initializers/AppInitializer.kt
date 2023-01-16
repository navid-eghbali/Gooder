package app.gooder.initializers

import gooder.base.initializer.Initializer
import javax.inject.Inject

class AppInitializer @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards Initializer>,
) {

    fun init() {
        initializers.forEach { it.init() }
    }
}
