package org.jetbrains.plugins.template

import com.intellij.ide.highlighter.XmlFileType
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.PathManager
import com.intellij.openapi.application.writeAction
import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.editor.EditorModificationUtil
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.psi.xml.XmlFile
import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import file_system.File
import file_system.FileManager
import kotlin.io.path.pathString


@TestDataPath("\$CONTENT_ROOT/src/test/testData")
class MyPluginTest : BasePlatformTestCase() {

    fun testXMLFile() {
        FileManager().writeFile(File("MyFirstConfigFile" , directoryPath = PathManager.getConfigPath() , extension = "config" , content = "PlaceHolder"))
        FileManager().readFile(name = "MyFirstConfigFile", extension = "config", directory = PathManager.getConfigPath() ,  onCompleted = {
           thisLogger().warn("onCompleted Called")
            if(it == null){
                thisLogger().warn("No File Retrieved")
            }
           else {
                thisLogger().warn("Content Retrieved = ${it.content}")
            }
        })
    }

    fun testRename() {
       // myFixture.testRename("foo.xml", "foo_after.xml", "a2")
    }

    fun testProjectService() {



    }

    override fun getTestDataPath() = "src/test/testData/rename"
}
