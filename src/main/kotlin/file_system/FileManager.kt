package file_system

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.PathManager
import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.testFramework.writeChild

class FileManager {


    fun writeFile(file: File) {
        WriteAction.run<Exception> {

            val lfs = LocalFileSystem.getInstance()
            val parent = lfs.refreshAndFindFileByPath(file.directoryPath)
            if (parent == null) {
                thisLogger().warn("${file.directoryPath} not found")
                return@run
            }
            val child = parent.writeChild(".${file.name}.${file.extension}", file.content)
            thisLogger().warn("File Created at path = ${child.canonicalPath}")
        }
    }

    fun readFile(
        name: String,
        directory: String,
        extension: String,
        onCompleted: (File?) -> Unit
    ) {
        ApplicationManager.getApplication().runReadAction {
            val completePath = File.buildCompletePath(directoryPath = directory , fileName = name , extension = extension)

            thisLogger().warn("Where = $completePath")
            val lfs = LocalFileSystem.getInstance()

            val result = lfs.findFileByPath(completePath)

            if (result == null) {
                thisLogger().warn("No File Found at ${completePath}")
                onCompleted(null)
                return@runReadAction
            }

            val content = result.inputStream.readAllBytes().decodeToString()
            onCompleted(File(name, directory, extension, content))
            thisLogger().warn("Returned Found File with content = ${content}")
        }
    }
}