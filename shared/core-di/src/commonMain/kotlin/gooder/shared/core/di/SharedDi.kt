package gooder.shared.core.di

import org.kodein.di.conf.ConfigurableDI
import org.kodein.di.direct
import org.kodein.di.instance

val sharedDi: ConfigurableDI = ConfigurableDI()

inline fun <reified T : Any> sharedDiInstance(): T = sharedDi.direct.instance()
