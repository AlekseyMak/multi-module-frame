package dev.elvir.auth_impl.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.elvir.auth_impl.R
import dev.elvir.auth_impl.di.AuthComponent
import dev.elvir.core.feature_component.DependencyManager
import dev.elvir.support_api.SupportRouter
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : AppCompatActivity() {

    @Inject
    lateinit var supportRouter: SupportRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        DependencyManager.getFeatureDependecy(this, AuthComponent::class.java).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        btnGoToSupport.setOnClickListener {
            supportRouter.startSupportScreen(this)
        }
    }
}
