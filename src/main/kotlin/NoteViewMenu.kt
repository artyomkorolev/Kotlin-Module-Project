import java.util.Scanner

class NoteViewMenu (private  val note : Note){
    private val scanner = Scanner(System.`in`)
    private var choice: Int = 0
    fun viewNote(){
        while (true){
            println("Заметка: ${note.name}")
            println("${note.text}")
            println("0. Вернуться в меню Заметок")
            try {
                choice = scanner.nextInt()
                if(choice== 0){
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