package dev.elvir.support_impl.di

import dagger.Component
import dagger.Module
import dagger.Provides
import dev.elvir.auth_api.AuthRouter
import dev.elvir.support_api.SupportApi
import dev.elvir.support_api.SupportRouter
import dev.elvir.support_impl.router.SupporRouterImpl
import dev.elvir.support_impl.ui.SupportActivity
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SupportScope


@Component(
    modules = [
        SupportModule::class,
        AuthStubModule::class
    ]
)
@SupportScope
interface SupportComponent : SupportApi {

    fun inject(supportActivity: SupportActivity)

}


@Module
class SupportModule {
    @Provides
//    @SupportScope
    fun provideSupportRouter(): SupportRouter = SupporRouterImpl()
}

@Module
class AuthStubModule {
    @Provides
    fun provideAuthRouter(): AuthRouter {
        throw IllegalAccessError("Shouldn't get here")
    }
}

interface Dependencies {

}