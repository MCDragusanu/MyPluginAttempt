package configurables

import com.intellij.openapi.options.Configurable
import com.intellij.ui.layout.selected
import components.FontEditorComponent
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collectLatest
import state.FontSettingsState
import javax.swing.JComponent

class FontEditorConfigurable:Configurable {
   private var  component:FontEditorComponent?= null
    override fun createComponent(): JComponent? {
        component = FontEditorComponent()
        return component!!.panel
    }

    override fun isModified(): Boolean {
        val current = FontSettingsState.getInstance()
        when{

        }
        return false
    }

    override fun apply() {
        TODO("Not yet implemented")
    }

    override fun getDisplayName(): String {
        TODO("Not yet implemented")
    }

    private fun fontWeightHasChanged(currentState: FontSettingsState):Boolean{
      return false
    }
}