public class Main {
    public static void main(String[] args) {
        String text= """
                ПРивет пока досвидос. Один, два, три! Создать программу обработки фрагмента текста учебника по программированию с использованием элементов, например: Символ, Слово, Предложение, Текст, Абзац, Листинг, Лексема, Знак препинания и др.
                Приложение должно осуществлять разбор текста на элементы с обязательной возможностью восстановления текста в исходном виде.
                Можно использовать шаблон Composite.
                Во всех задачах с формированием текста разрешено заменять табуляции и последовательности пробелов одним пробелом.
                Для демонстрации работы приложения использовать unit тесты.
                Использовать logging.
                Использовать библиотеки сборки.
                """;

        BuildTextObjectService service = new BuildTextObjectService();

        EditTextService editTextService = new EditTextService();
        System.out.println(editTextService.getSortedSentencesByWordCount(service.parseText(text)));
        System.out.println(editTextService.getSentencesWithWordReplacements(service.parseText(text)));
        System.out.println(service.parseText(text));
    }

}
