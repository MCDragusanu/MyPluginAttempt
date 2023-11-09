package appereance

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.StoragePathMacros.WORKSPACE_FILE
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.colors.FontPreferences
import com.intellij.util.xmlb.XmlSerializerUtil
import example.AppSettingState



@State(
    name = "EditorAppearanceSettings",
    storages = [Storage("editor-appearance.xml")],
    reloadable = true
)
data class AppearanceSettingsState(
    var editorFontSize:Int = EditorColorsManager.getInstance().globalScheme.editorFontSize,
    var consoleFontSize:Int = EditorColorsManager.getInstance().globalScheme.consoleFontSize,
    //TODO add more fields
) : PersistentStateComponent<AppearanceSettingsState> {
    override fun getState(): AppearanceSettingsState? {
        EditorColorsManager.getInstance().globalScheme.editorFontSize = this.editorFontSize
        EditorColorsManager.getInstance().globalScheme.consoleFontSize = this.consoleFontSize
        return this
    }

    override fun loadState(state: AppearanceSettingsState) {
        XmlSerializerUtil.copyBean(state, this);
        thisLogger().debug("${state.consoleFontSize} / ${state.editorFontSize}")
    }

    companion object{
        fun getInstance():AppearanceSettingsState{
            return ApplicationManager.getApplication().getService(AppearanceSettingsState::class.java)
        }


    }


}