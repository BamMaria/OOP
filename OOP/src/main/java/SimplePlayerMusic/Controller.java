package SimplePlayerMusic;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
//import javax.media.Player;
//import javax.media.Manager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ActionListener, ChangeListener {
    //private Player player;
    private PlaylistsContainer playlists;
    private View GUI;

    private int currentPlaylistIndex;
    private int currentSongIndex;
    private boolean isItPlaying;        // flag to change play icon to pause and vice versa

    /**
     * Default constructor. Loads the first song in the playlist (on top of the multiple initializations of the class members).
     */
    public Controller() throws Exception {
        this.playlists = new PlaylistsContainer();
        this.GUI = new View();

        addActionListeners();

        loadSongsIntoPlaylist("anime_playlist1");
        loadSongsIntoPlaylist("blackbear");

        // volume slider change listener
        GUI.getVolumeSlider().addChangeListener(this);

        // loads the first song of the first playlist
        currentPlaylistIndex = 0;
        currentSongIndex = 0;
        initializePlayer(currentPlaylistIndex, currentSongIndex);
        isItPlaying = false;
    }


    private void loadSongsIntoPlaylist(String playlistName) throws Exception {
        URL path = Controller.class.getResource("playlists/" + playlistName + ".txt");
        File file = new File(path.getFile());
        playlists.add(new Playlist());
        // right parameter <= index of the song that was just added
        playlists.loadSongs(file, playlists.getNumberOfPlaylists() - 1);
    }

    /**
     * Loads a song file into the player.
     *
     * @param currentPlaylistIndex    the index of the playlist (in playlistsContainer) to be loaded.
     * @param currentSongIndex        the index of the song (in playlist) to be loaded.
     */
    private void initializePlayer(int currentPlaylistIndex, int currentSongIndex) throws Exception {
       // player = Manager.createRealizedPlayer(
            //    (playlists.getSong(currentPlaylistIndex, currentSongIndex)).toURI().toURL()
       // );
    }


    private void loadSongAndPlay(int currentPlaylistIndex, int currentSongIndex) throws Exception {
        stopCurrentSong();
        initializePlayer(currentPlaylistIndex, currentSongIndex);
        start();
    }

    private void addActionListeners() {
        GUI.getPrevPlaylistButton().addActionListener(this);
        GUI.getBackButton().addActionListener(this);
        GUI.getPlayButton().addActionListener(this);
        GUI.getSkipButton().addActionListener(this);
        GUI.getNextPlaylistButton().addActionListener(this);
    }

    /**
     * Checks if a button is clicked, and executes the appropriate method.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        resetIcons();

        if ((((JButton) e.getSource()) == GUI.getPrevPlaylistButton())) {
            try {
                prevPlaylist();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        if ((((JButton) e.getSource()) == GUI.getBackButton())) {
            try {
                back();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        // TODO: make it so the pause button becomes a play button
        // once the song is over (when song completes, go to next)
        if ((((JButton) e.getSource()) == GUI.getPlayButton())) {
            if (!isItPlaying) {
                start();
                changePlayToPause();
            } else {
                stopCurrentSong();
                changePauseToPlay();
            }
        }

        if ((((JButton) e.getSource()) == GUI.getSkipButton())) {
            try {
                skip();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        if ((((JButton) e.getSource()) == GUI.getNextPlaylistButton())) {
            try {
                nextPlaylist();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }


    private void start() {
       /// player.start();

       // (player.getGainControl()).setLevel((float)GUI.getVolumeSlider().getValue() / 150.0f);
        GUI.setTitle(playlists.getSong(currentPlaylistIndex, currentSongIndex).getName());
        isItPlaying = true;
    }

    /**
     * Stops the player.
     */
    private void stopCurrentSong() {
       // player.stop(); /??
        isItPlaying = false;
    }

    /**
     * Loads the first song of the previous playlist.
     */
    private void prevPlaylist() throws Exception {
        if (currentPlaylistIndex == 0) {
            GUI.getPrevPlaylistButton().setText(null);
            changePrevPlaylistToError(); // display error on prevPlaylistButton
        } else {
            currentSongIndex = 0;    // reset song index
            loadSongAndPlay(--currentPlaylistIndex, currentSongIndex);
            changePlayToPause();
        }
    }

    /**
     * Loads a song with the currentSongIndex (that was just decremented), if it exists, into the player.
     */
    private void back() throws Exception {
        if (currentSongIndex == 0) {
            changeBackToError();
        } else {    // In any other case, just load the previous song and immediately start the player.
            loadSongAndPlay(currentPlaylistIndex, --currentSongIndex);
            changePlayToPause();
        }
    }

    /**
     * Loads a song with the currentSongIndex (that was just incremented), if it exists, into the player.
     */
    private void skip() throws Exception {
        if (currentSongIndex == playlists.getPlaylist(currentPlaylistIndex).getCount() - 1) {
            changeSkipToError();
        } else { // In any other case, just load the next song and immediately start the player.
            loadSongAndPlay(currentPlaylistIndex, ++currentSongIndex);
            changePlayToPause();
        }
    }

    /**
     * Loads the first song of the next playlist.
     */
    private void nextPlaylist() throws Exception {
        if (currentPlaylistIndex == playlists.getNumberOfPlaylists() - 1) {
            GUI.getNextPlaylistButton().setText(null);
            changeNextPlaylistToError(); // display error on nextPlaylistButton
        } else {
            currentSongIndex = 0;   // reset song index
            loadSongAndPlay(++currentPlaylistIndex, currentSongIndex);
            changePlayToPause();
        }
    }

    /**
     * Changes the play icon to a pause icon.
     */
    private void changePlayToPause() {
        try {
            Image icon = ImageIO.read(View.class.getResource("icons/pause.png"));
            GUI.getPlayButton().setIcon(new ImageIcon(icon));
        } catch (IOException ex) {
            System.out.println("icons/pause.png not found.");
        }
    }

    /**
     * Changes the pause icon to a play icon.
     */
    private void changePauseToPlay() {
        try {
            Image icon = ImageIO.read(View.class.getResource("icons/play.png"));
            GUI.getPlayButton().setIcon(new ImageIcon(icon));
        } catch (IOException ex) {
            System.out.println("icons/play.png not found.");
        }
    }

    /**
     * Changes the prevPlaylist icon to an error icon. To be used when
     * user tries to go back past the very first playlist.
     */
    private void changePrevPlaylistToError() {
        try {
            Image icon = ImageIO.read(View.class.getResource("icons/error.png"));
            GUI.getPrevPlaylistButton().setIcon(new ImageIcon(icon));
        } catch (IOException ex) {
            System.out.println("icons/error.png not found.");
        }
    }

    /**
     * Changes the back icon to an error icon. To be used when
     * user tries to go back past the very first song.
     */
    private void changeBackToError() {
        try {
            Image icon = ImageIO.read(View.class.getResource("icons/error.png"));
            GUI.getBackButton().setIcon(new ImageIcon(icon));
        } catch (IOException ex) {
            System.out.println("icons/error.png not found");
        }
    }

    /**
     * Changes the skip icon to an error icon. To be used when
     * user tries to skip past the very last song.
     */
    private void changeSkipToError() {
        try {
            Image icon = ImageIO.read(View.class.getResource("icons/error.png"));
            GUI.getSkipButton().setIcon(new ImageIcon(icon));
        } catch (IOException ex) {
            System.out.println("icons/error.png not found.");
        }
    }

    /**
     * Changes the nextPlaylist icon to an error icon. To be used when
     * user tries to go past the very last playlist.
     */
    private void changeNextPlaylistToError() {
        try {
            Image icon = ImageIO.read(View.class.getResource("icons/error.png"));
            GUI.getNextPlaylistButton().setIcon(new ImageIcon(icon));
        } catch (IOException ex) {
            System.out.println("icons/error.png not found.");
        }
    }

    /**
     * Resets the prevPlaylist, skip, back, and nextPlaylist, button icons.
     * This is used when one of the buttons have an error icon.
     */
    private void resetIcons() {
        try {
            Image icon = ImageIO.read(View.class.getResource("icons/prev.png"));
            GUI.getBackButton().setIcon(new ImageIcon(icon));
        } catch (IOException ex) {
            System.out.println("icons/prev.png not found");
        }

        try {
            Image icon = ImageIO.read(View.class.getResource("icons/next.png"));
            GUI.getSkipButton().setIcon(new ImageIcon(icon));
        } catch (IOException ex) {
            System.out.println("icons/next.png not found");
        }

        GUI.getPrevPlaylistButton().setIcon(null);
        GUI.getPrevPlaylistButton().setText("PP");

        GUI.getNextPlaylistButton().setIcon(null);
        GUI.getNextPlaylistButton().setText("NP");
    }

    /**
     * Checks if the volume slider level is changed.
     */
    @Override
    public void stateChanged(ChangeEvent e) {

      //  (player.getGainControl()).setLevel((float)GUI.getVolumeSlider().getValue() / 150.0f);
    }
}
