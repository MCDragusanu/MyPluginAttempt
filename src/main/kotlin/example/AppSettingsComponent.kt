package example

import com.intellij.openapi.keymap.KeymapManager
import com.intellij.util.ui.FormBuilder

import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JTextField

//Represents the UI Tab / component itself
class AppSettingsComponent {


     val panel: JPanel
     val textField: JTextField = JTextField()
     val button: JButton = JButton()

    init {

        panel = FormBuilder.createFormBuilder().addLabeledComponent("Enter Message Here", textField, 1)
            .addLabeledComponent("Submit", button).panel
    }

}