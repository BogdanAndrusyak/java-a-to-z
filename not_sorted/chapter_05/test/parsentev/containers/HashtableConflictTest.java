package parsentev.containers;

import org.junit.Test;

import java.util.Hashtable;

/**
 * TODO: comment.
 */
public class HashtableConflictTest {

    @Test
    public void test() {
        /*
            Создадим Hashtable с текущей capacity=3
            (определена при создании, т.к. по умолчанию capacity=11,
            и это значение не уменьшается со временем).

            Добавим элементы типа String, с соответствующими ключами типа String.

            Индекс во внутреннем массиве вычисляеться по хешу: int index = (hash & 0x7FFFFFFF) % tab.length;
            Например для элемента с ключем "B": индекс = 0 (66 % 3 = 0).

            получим что-то вроде этого:
            http://pixvenue.com/showimage/12943origi_4940999_21345709.jpg
        */
        Hashtable<String, String> hashtable = new Hashtable(3,100F);
        hashtable.put("A","book"); //"A".hashCode() = 65
        hashtable.put("B","test"); //"B".hashCode() = 66
        hashtable.put("C","random"); //"C".hashCode() = 67

        /* Коллизия индексов.
            Теперь вставляем новый элемент в Hashtable.

            Видим, что во внутреннем массиве, для разных элементов, операция
            вычисления индекса дала один и тот же результат. Налицо коллизия
            индексов. Поэтому, во внутреннем массиве, по индексу 2, теперь находится
            элемент "D", который ссылается на элемент "A". Получился односвязный
            список.

            http://pixvenue.com/showimage/12661origi_3425342_21345765.jpg
         */
        hashtable.put("D","jump");

        /* Коллизия хешов.
            Теперь вставим в Hashtable еще один элемент с ключем.
            Так как hash "\0A" = 65 = "A" - получим коллизию хешей.
            Естественно, индекс во внутреннем массиве остается тот же.
            Но поскольку Hashtable сравнивает ключи не только hashCode, но еще и по equals
            оба объекта будут сохранены.

            http://pixvenue.com/showimage/13069origi_1202392_21345937.jpg
         */
        hashtable.put("\0A","dr.evil"); // "\0A".hashCode() = 65.

        /*
            Вывод: коллизии в Hashtable структурах решаются через односвязные списки.
            Однак для эффективной (быстрой) работы все-таки стоит избегать коллизий хешей ключа.

            Материал позаимствован с:
            http://restless-man.livejournal.com/26794.html
         */
    }
}
