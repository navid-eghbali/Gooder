package gooder.shared.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import gooder.shared.core.di.sharedDiInstance
import gooder.shared.network.api.GooderNetworkDataSource
import org.kodein.di.DI

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @IntoSet
    fun provideNetworkModule(): DI.Module = networkModule

    @Provides
    fun provideGooderNetworkDataSource(): GooderNetworkDataSource = sharedDiInstance()
}
