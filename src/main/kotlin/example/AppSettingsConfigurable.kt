package example

import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.options.Configurable

import javax.swing.JComponent




/**
 * Provides controller functionality for application settings.
 */
internal class AppSettingsConfigurable : Configurable {

    private var mySettingsComponent: AppSettingsComponent? = null

    override fun createComponent(): JComponent? {
        mySettingsComponent = AppSettingsComponent()
        return mySettingsComponent!!.panel
    }


    override fun isModified(): Boolean {
          val current = AppSettingState().getInstance()
          var hasChanged = false
          mySettingsComponent?.let {
            hasChanged =  it.textField.text!=current.content
          }
         return hasChanged
    }

    override fun apply() {

        val current = AppSettingState().getInstance()
         mySettingsComponent?.let{
             current.content = it.textField.text
         }


    }


    override fun getDisplayName(): String {
     return  "My First Compomponent"
    }
    override fun reset() {
        val settings = AppSettingState().getInstance()
        mySettingsComponent?.let {
            it.textField.text = settings.content
        }

    }

    override fun disposeUIResources() {
        mySettingsComponent = null
    }
}