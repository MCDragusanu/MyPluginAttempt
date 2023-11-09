package appereance

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

 internal class AppearanceSettingsConfigurable:Configurable {
    private var component: AppearanceSettingsComponent? = null
     init {

     }
    override fun createComponent(): JComponent? {
        component = AppearanceSettingsComponent()
        return component?.jPanel
    }

    override fun isModified(): Boolean {
        val persisted = AppearanceSettingsState.getInstance().state
        component?.let {
            val current = it.getCurrentState()
            return (persisted?.consoleFontSize != current.consoleFontSize) && (persisted?.editorFontSize != current.consoleFontSize)
        }
        return false
    }

    override fun apply() {
        thisLogger().warn("apply called")

        component?.let {
            val current = AppearanceSettingsState.getInstance().state
            current?.consoleFontSize = it.getConsoleFontSize() ?: 13
            current?.editorFontSize = it.getEditorFontSize() ?: 13
            thisLogger().warn("current state updated from UI layer")
            EditorColorsManager.getInstance().updateGlobalState(current!!)
            ApplicationManager.getApplication().runWriteAction {

            }
        }
    }

    override fun getDisplayName(): String {
        return "My Custom Appearance Editor"
    }

     override fun reset() {

         component?.let {
             val settings = AppearanceSettingsState.getInstance().state
             it.editorFontSizeTextField.text = "13"
             it.consoleFontSizeTextField.text = "13"
         }

     }

     override fun disposeUIResources() {
        component = null
     }
}