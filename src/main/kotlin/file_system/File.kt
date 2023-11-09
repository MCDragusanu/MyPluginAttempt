package file_system



data class File(val name:String,val content:String , val directoryPath:String  ,val extension:String){



    companion object{
        fun buildCompletePath(directoryPath: String , fileName:String , extension: String ):String{
           return "${directoryPath}/.${fileName}.${extension}"
        }
    }
}