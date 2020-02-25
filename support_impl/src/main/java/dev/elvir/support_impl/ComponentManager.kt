package dev.elvir.support_impl

import android.content.Context
import dev.elvir.support_impl.di.DaggerSupportComponent
import dev.elvir.support_impl.di.SupportComponent


object ComponentManager {

    private lateinit var supportComponent: SupportComponent

    fun plusSupportComponent(context: Context): SupportComponent {
        return DaggerSupportComponent.builder()
            .build()
            .also { supportComponent = it }
    }

    fun getSupportComponent(context: Context): SupportComponent {
        return if (this::supportComponent.isInitialized) {
            supportComponent
        } else {
            plusSupportComponent(context)
        }
    }

}

