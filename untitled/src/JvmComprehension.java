
    public class JvmComprehension {//все данные о классе хранятся в metaspace
        //Application ClassLoader загрузил класс JvmComprehension в metaspace
        public static void main(String[] args) {//В момент вызова метода создается фрейм в стеке

            int i = 1;                      // 1. примитивная переменная присваиваем 1, выделяется память в стеке
            Object o = new Object();        // 2. создаем объект и выделяем память в стеке со сылкой на сам объект в куче(heap)
            Integer ii = 2;                 // 3. объявляем ссылочный тип переменной(Integer)помещаем в стек и выделяется память для объекта в куче
            printAll(o, i, ii);             // 4. выводим все в консоль, все занимают место в стеке(stack) o и ii со сылкой на объекты в куче
            System.out.println("finished"); // 7. создается и выводится в консоль новый фрейм "finished", занимает место в стеке с сылкой на String в куче
        }

        private static void printAll(Object o, int i, Integer ii) {//В момент вызова метода создается новый фрейм в стеке
            Integer uselessVar = 700;                   // 5. объявляем ссылочный тип и присваиваем 700, занимает место в стеке со ссылкой на объект в куче
            System.out.println(o.toString() + i + ii);  // 6. выводим в консоль, создаются фреймы println и ссылка на toString в стеке + все переменные, но o и ii,toString  имеют ссылку на объекты в куче
        }
    }
    //Код выполняется строка за строкой
    //Методы компилируются в машинный код прямо во время выполнения
    //По завершению все удаляется, работает сборщик мусора. используется метод обход графа достижимых объектов.
    //Обычно для сборки мусора происходит приостановка программы - полная остановка
    //потоков программы для безопасной сборки мусора
