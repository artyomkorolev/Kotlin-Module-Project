import java.util.Scanner

class NotesMenu(private  val archive: Archive, private val notes: MutableList<Note>) {
    private val scanner = Scanner(System.`in`)



    private var choice : Int = 0

    private fun addNote() {
        print("Введите имя Заметки: ")

        val newNoteName = readLine()?.takeIf { it.isNotBlank() }
        println()

        print("Что хотите записать?")
        val newNoteText = readLine()?.takeIf { it.isNotBlank() }

        if(newNoteName!=null && newNoteText!= null){
            val newNote = Note(newNoteName,newNoteText)
            notes.add(newNote)

        }else {
            println("Имя Заметки или ее текст  не может быть пустым. Попробуйте снова.")
            addNote()
        }
    }

    fun init(){
        while (true){
            println("Список заметок")
            println("0. Создать Заметку")

            for ((index, note) in notes.withIndex()){
                println("${index + 1}. ${note.name}")
            }
            println("${notes.size+1}. Вернуться в меню Архивов")


            try {
                choice = scanner.nextInt()
                if (choice == 0) {
                    addNote()
                }else if (choice in 1 .. notes.size){
                    val selectedNote = notes[choice-1]
                    val noteViewMenu = NoteViewMenu(selectedNote)
                    noteViewMenu.viewNote()
                }else if (choice == notes.size+1){
                    return
                }else{
                    println("Некорректный выбор. Пожалуйста, выберите снова.")
                }


        }catch (e: java.util.InputMismatchException){
            println("Ошибка! Введите корректное число.")
            scanner.nextLine()
        }
        }

    }
}
