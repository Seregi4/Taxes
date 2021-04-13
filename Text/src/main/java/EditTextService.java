import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EditTextService {

    public ArrayList<Sentence> getSortedSentencesByWordCount(Text text) {
        ArrayList<Sentence> sortedSentences = new ArrayList<>();


        for (Paragraph paragraphs : text.getParagraphs()) {
            sortedSentences.addAll(paragraphs.getSentences());
        }

        return (ArrayList<Sentence>) sortedSentences.stream()
                .sorted(Comparator.comparing(sentence -> sentence.getWords().size()))
                .collect(Collectors.toList());
    }

    public ArrayList<Sentence> getSentencesWithWordReplacements(Text text) {
        ArrayList<Sentence> replaceWordsSentence = new ArrayList<>();

        for (Paragraph paragraphs : text.getParagraphs()) {
            for (Sentence sentence : paragraphs.getSentences()) {
                replaceWordsSentence.add(sentence);
                String tempWord;
                tempWord = sentence.getWords().get(0).getValue();
                sentence.getWords().get(0).setValue(sentence.getWords().get(sentence.getWords().size() - 1).getValue());
                sentence.getWords().get(sentence.getWords().size() - 1).setValue(tempWord);
            }
        }
        return replaceWordsSentence;
    }

}
