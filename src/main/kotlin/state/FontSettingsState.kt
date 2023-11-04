package state

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import font.Font

@State(
    name = "org.intellij.sdk.settings.form_settings",
    storages = [Storage("SdkSettingsPlugin.xml")]
)
class FontSettingsState private constructor(): PersistentStateComponent<FontSettingsState> {
    var fontDescriptor = Font()
    override fun getState(): FontSettingsState? {
        return this
    }

    override fun loadState(state: FontSettingsState) {
      XmlSerializerUtil.copyBean(state , this)
    }

    companion object{
        fun getInstance(): FontSettingsState {
            return ApplicationManager.getApplication().getService(FontSettingsState::class.java)
        }
    }
}