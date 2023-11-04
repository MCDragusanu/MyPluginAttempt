import com.esotericsoftware.minlog.Log
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

import com.intellij.openapi.diagnostic.Logger
import com.intellij.util.xmlb.XmlSerializerUtil

//The data model itself
//this contains displayed data@
@State(
   name = "org.intellij.sdk.settings.AppSettingsState",
    storages = [Storage("SdkSettingsPlugin.xml")]
)
class AppSettingState:PersistentStateComponent<AppSettingState> {
    private val logger =  Logger.getInstance(AppSettingState::class.java)
    //TODO implement data members displayed
    var content:String = ""
    override fun getState(): AppSettingState? {
        logger.info("getState Called")
        return this
    }

    override fun loadState(state: AppSettingState) {
        XmlSerializerUtil.copyBean(state, this);
    }

    fun getInstance():AppSettingState{
        return ApplicationManager.getApplication().getService(AppSettingState::class.java)
    }
}