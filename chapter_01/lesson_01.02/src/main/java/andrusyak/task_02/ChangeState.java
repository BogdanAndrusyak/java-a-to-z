package andrusyak.task_02;

/**
 * Посмотрите данный код и ответьте на вопросы.
 * Сколько объектов класс Сlaim создано?
 * Что будет выведенно на консоль?
 *
 * Создан один объект класса Сlaim.
 * Будет выведено 'task' так как метод processClaim(Claim value) изменил поле переданного объекта
 */
public class ChangeState {
    public static class Claim {
        public String name;
    }

    public static void main(String[] args) {
        Claim claim = new Claim();
        claim.name = "bug";
        processClaim(claim);
        System.out.println(claim.name);
    }

    private static void processClaim(Claim value) {
        value.name = "task";
    }
}