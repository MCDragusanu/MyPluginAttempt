package appereance

import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.editor.colors.EditorColorsManager


fun EditorColorsManager.updateGlobalState(appearanceSettingsState: AppearanceSettingsState){
    this.globalScheme.consoleFontSize = appearanceSettingsState.consoleFontSize
    this.globalScheme.editorFontSize = appearanceSettingsState.editorFontSize
    thisLogger().warn("global state Changed")
}