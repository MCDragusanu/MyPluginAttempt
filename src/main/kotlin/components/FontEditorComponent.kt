package components

import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.ui.JBMenuItem
import com.intellij.ui.components.JBMenu
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import font.Font
import font.FontFamily
import font.FontWeight
import state.FontSettingsState
import javax.swing.JMenu
import javax.swing.JPanel
import javax.swing.JTextField


class FontEditorComponent {
    val fontDescriptor = FontSettingsState.getInstance()

    var panel: JPanel? = null

    val fontFamilyDropDownMenu = JBMenu()

    val fontFamilyItems = FontFamily.entries.map { JBMenuItem(it.name) }

    val fontSizeTextField = JBTextField()

    val lineSpacingTextField = JBTextField()

    val fontWeightItems = FontWeight.entries.map { JBMenuItem(it.name) }
    val fontWeightDropDownMenu = JBMenu()

    init {
        panel = FormBuilder.createFormBuilder()
            .addLabeledComponent("Font Family", fontFamilyDropDownMenu.apply { fontWeightItems.onEach { this.add(it) } })
            .addLabeledComponent("Font Weight", fontFamilyDropDownMenu.apply { fontFamilyItems.onEach { add(it) } })
            .addLabeledComponent("Font Size", fontSizeTextField)
            .addLabeledComponent("Line Spacing", lineSpacingTextField).panel
    }

    fun onFontFamilyChanged(fontFamily: FontFamily) {

    }

    fun onFontSizeChanged(newValue: Double) {

    }

    fun onLineSpacingChanged(newValue: Double) {

    }

    fun onFontWeightChanges(newWeight: FontWeight){

    }


}