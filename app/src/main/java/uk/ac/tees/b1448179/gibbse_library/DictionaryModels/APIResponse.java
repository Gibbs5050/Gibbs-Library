package uk.ac.tees.b1448179.gibbse_library.DictionaryModels;

import java.util.List;

public class APIResponse {

    String word = "";
    List<Phonetics> phonetics = null;
    List<Meanings> meanings =  null;

    //generate getters and setters


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Phonetics> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<Phonetics> phonetics) {
        this.phonetics = phonetics;
    }

    public List<Meanings> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meanings> meanings) {
        this.meanings = meanings;
    }
}
