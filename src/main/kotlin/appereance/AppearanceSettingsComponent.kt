package appereance

import com.intellij.util.ui.FormBuilder
import javax.swing.JPanel
import javax.swing.JTextField

internal class AppearanceSettingsComponent {

    var jPanel: JPanel? = null
    val editorFontSizeTextField: JTextField = JTextField()
    val consoleFontSizeTextField: JTextField = JTextField()

    init {
        jPanel = FormBuilder.createFormBuilder().addLabeledComponent("Editor Font Size", editorFontSizeTextField)
            .addLabeledComponent("Console Font Size", consoleFontSizeTextField).panel
    }

    fun getCurrentState():AppearanceSettingsState {
        val editorFontSize = getEditorFontSize()
        val consoleFontSize = getConsoleFontSize()
        if (editorFontSize == null) return AppearanceSettingsState(editorFontSize?:13 , consoleFontSize?:13)
        if (consoleFontSize == null) return AppearanceSettingsState(editorFontSize?:13 , consoleFontSize?:13)
        return AppearanceSettingsState(editorFontSize, consoleFontSize)
    }

    fun getEditorFontSize():Int?  = try {
        editorFontSizeTextField.text.toInt()
    } catch (e: Exception) {
        null
    }

    fun getConsoleFontSize():Int? =  try {
        consoleFontSizeTextField.text.toInt()
    } catch (e: Exception) {
        null
    }
}