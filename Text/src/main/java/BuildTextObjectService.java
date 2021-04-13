import java.util.ArrayList;

public class BuildTextObjectService {


    public Text parseText(String text) {

        Text resultText = new Text();

        String[] paragraphs = text.split("\\n");
        ArrayList<Paragraph> paragraphs1 = new ArrayList<>();


        for (String paragraph : paragraphs) {
            paragraphs1.add(parseParagraph(paragraph));
        }
        resultText.setParagraphs(paragraphs1);
        return resultText;

    }


    private static Paragraph parseParagraph(String paragraph) {

        Paragraph resultParagraph = new Paragraph();
        String[] sentences = paragraph.split("[.!?]");
        ArrayList<Sentence> sentences1 = new ArrayList<>();


        for (String sentence : sentences) {
            sentences1.add(parseSentence(sentence));
        }
        resultParagraph.setSentences(sentences1);
        return resultParagraph;
    }

    private static Sentence parseSentence(String sentence) {

        Sentence resultSentence = new Sentence();
        String[] words = sentence.split(" ");
        ArrayList<Word> words1 = new ArrayList<>();


        for (String word : words) {

            words1.add(parseWord(word));
        }
        resultSentence.setWords(words1);
        return resultSentence;
    }

    private static Word parseWord(String word) {
        Word resultWord = new Word();
        resultWord.setValue(word);
        return resultWord;
    }

}
