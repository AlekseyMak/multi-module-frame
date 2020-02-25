package dev.elvir.baseframeprojects.di

import dagger.Component
import dev.elvir.auth_impl.di.AuthComponent
import dev.elvir.auth_impl.di.AuthModule
import dev.elvir.support_impl.di.SupportComponent
import dev.elvir.support_impl.di.SupportModule

@AppScope
@Component(modules = [SupportModule::class, AuthModule::class])
interface SupportAuthBridgeComponent : AuthComponent, SupportComponent {

}