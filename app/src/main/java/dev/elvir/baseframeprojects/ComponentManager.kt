package dev.elvir.baseframeprojects

import android.content.Context
import dev.elvir.auth_api.AuthApi
import dev.elvir.auth_impl.di.AuthComponent
import dev.elvir.baseframeprojects.di.AppComponent
import dev.elvir.baseframeprojects.di.DaggerAppComponent
import dev.elvir.baseframeprojects.di.DaggerSupportAuthBridgeComponent
import dev.elvir.support_api.SupportApi
import dev.elvir.support_impl.di.SupportComponent


/**
 * @author Elvir
 * Created by ElikJaday on 08/02/2020.
 * @see
 * Visit my GitHub
 * https://github.com/ElikJaday
 */
class ComponentManager {

    private lateinit var appComponent: AppComponent

    private val authComponentManager by lazy {
        dev.elvir.auth_impl.ComponentManager
    }
    private val supportComponentManager by lazy {
        dev.elvir.support_impl.ComponentManager
    }

    private val supportAuthBridgeComponent by lazy {
        DaggerSupportAuthBridgeComponent.builder()
            .build()
    }

    fun plusAppComponent(): AppComponent = DaggerAppComponent
        .builder()
        .build().also { appComponent = it }


    fun <T> componentBuilder(
        api: Class<T>,
        context: Context
    ): T {
        return when (api) {
            AuthApi::class.java -> authComponentManager.getAuthComponent(context)
            SupportApi::class.java -> supportComponentManager.getSupportComponent(context)
            SupportComponent::class.java -> supportAuthBridgeComponent
            AuthComponent::class.java -> supportAuthBridgeComponent
            else -> throw RuntimeException("component API not found ")
        } as T
    }


}


