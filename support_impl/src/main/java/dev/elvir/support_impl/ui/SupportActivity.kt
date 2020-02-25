package dev.elvir.support_impl.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.elvir.auth_api.AuthRouter
import dev.elvir.core.feature_component.DependencyManager
import dev.elvir.support_impl.R
import dev.elvir.support_impl.di.SupportComponent
import kotlinx.android.synthetic.main.activity_support.*
import javax.inject.Inject

class SupportActivity : AppCompatActivity() {

    @Inject
    lateinit var authRouter: AuthRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        DependencyManager.getFeatureDependecy(this, SupportComponent::class.java).inject(this)
        DependencyManager
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support)
        btnGoToAuth.setOnClickListener {
            authRouter.startAuthScreen(this)
        }
    }
}
