package dev.elvir.auth_impl

import android.content.Context
import dev.elvir.auth_impl.di.AuthComponent
import dev.elvir.auth_impl.di.DaggerAuthComponent

object ComponentManager {

    private lateinit var authComponent: AuthComponent

    fun plusAuthComponent(context: Context): AuthComponent {
        return DaggerAuthComponent.builder()
            .build()
            .also { authComponent = it }
    }


    fun getAuthComponent(context: Context): AuthComponent {
        return if (this::authComponent.isInitialized) {
            authComponent
        } else {
            plusAuthComponent(context)
        }
    }

}

