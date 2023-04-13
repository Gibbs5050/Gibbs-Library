package uk.ac.tees.b1448179.gibbse_library.DictionaryModels;

import java.util.List;

public class Definitions {

    //create variables to match dictionary API
    String definition = "";
    String example = "";
    List<String> synonyms = null;
    List<String> antonyms = null;



    //generate getter setter
    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(List<String> antonyms) {
        this.antonyms = antonyms;
    }

}