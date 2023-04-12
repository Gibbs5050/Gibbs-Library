package uk.ac.tees.b1448179.gibbse_library.DictionaryModels;

import android.hardware.lights.LightState;

import java.util.List;

public class Meanings {

    String partOfSpeech = "";
    List<Definitions> definitions = null;

    //generate getter setter

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<Definitions> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definitions> definitions) {
        this.definitions = definitions;
    }
}
