package SimplePlayerMusic;

import java.util.ArrayList;

public class Model {
    private ArrayList<String> playlist;

    Model() {
        playlist = new ArrayList<String>();
    }

    public void add(String fileName) {
        playlist.add(fileName);
    }

    public String get(int index) {
        return playlist.get(index);
    }

    public int getCount() {
        return playlist.size();
    }
}