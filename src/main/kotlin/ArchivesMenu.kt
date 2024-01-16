import java.util.Scanner

class ArchivesMenu {
    private val scanner = Scanner(System.`in`)
    private val archives = mutableListOf<Archive>()
    private val notes = mutableListOf<Note>()
    private var choice: Int = 0
    fun Archivemenu(){

        while (true){
            println("Список архивов")
            println("0. Создать Архив")

            for ((index, archive) in archives.withIndex()){
                println("${index + 1}. ${archive.name}")
            }
            println("${archives.size + 1}. Выход")
            try {
                choice = scanner.nextInt()
                 if (choice == 0) {
                     addArchive()

                 }else if (choice in 1 .. archives.size) {
                     val selectedArchive = archives[choice - 1]
                     val notesMenu = NotesMenu(selectedArchive, notes )
                     notesMenu.init()
                 } else if (choice == archives.size+1){
                     println("Выход. До свидания!")
                     return
                 } else{
                     println("Некорректный выбор. Пожалуйста, выберите снова.")
                 }
            }catch (e: java.util.InputMismatchException){
                println("Ошибка! Введите корректное число.")
                scanner.nextLine()
            }

        }
    }

    fun addArchive(){
        print("Введите имя нового архива: ")

        val newArchiveName = readLine()?.takeIf { it.isNotBlank() }

        if(newArchiveName!=null){
            val newArchive = Archive(newArchiveName, mutableListOf())
            archives.add(newArchive)

        }else {
            println("Имя архива не может быть пустым. Попробуйте снова.")
            addArchive()
        }



    }
}
