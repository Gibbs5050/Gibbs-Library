package uk.ac.tees.b1448179.gibbse_library;

import uk.ac.tees.b1448179.gibbse_library.DictionaryModels.APIResponse;

public interface OnFetchDataListener {
    //methods
    void onFetchData(APIResponse apiResponse, String message);
    void  onError (String message);
}
