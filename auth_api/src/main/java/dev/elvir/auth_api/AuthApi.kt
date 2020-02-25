package dev.elvir.auth_api

import android.content.Context

interface AuthApi {

    fun provideAuthRouter(): AuthRouter

}

interface AuthRouter {

    fun startAuthScreen(context: Context)

}

