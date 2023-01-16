package app.gooder.initializers

import gooder.base.initializer.Initializer
import gooder.shared.core.di.sharedDi
import org.kodein.di.DI
import javax.inject.Inject

class SharedModulesInitializer @Inject constructor(
    private val sharedModules: Set<DI.Module>
) : Initializer {

    override fun init() {
        sharedDi.addConfig {
            sharedModules.forEach { import(it) }
        }
    }
}
