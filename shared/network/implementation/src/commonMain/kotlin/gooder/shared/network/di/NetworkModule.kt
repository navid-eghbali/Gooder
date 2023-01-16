package gooder.shared.network.di

import gooder.shared.network.GooderNetworkClient
import gooder.shared.network.api.GooderNetworkDataSource
import gooder.shared.network.getPlatformHttpClient
import kotlinx.serialization.json.Json
import org.kodein.di.DI
import org.kodein.di.bindSingleton

val networkModule: DI.Module = DI.Module(name = "NetworkModule") {

    bindSingleton<GooderNetworkDataSource> {
        val json = Json {
            ignoreUnknownKeys = true
            encodeDefaults = true
        }
        GooderNetworkClient(getPlatformHttpClient(json))
    }
}
