package app.gooder.di

import app.gooder.initializers.SharedModulesInitializer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import gooder.base.initializer.Initializer

@Module
@InstallIn(SingletonComponent::class)
abstract class InitializerBinds {

    @Binds
    @IntoSet
    abstract fun provideSharedModulesInitializer(bind: SharedModulesInitializer): Initializer
}
