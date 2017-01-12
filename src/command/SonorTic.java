package command;

import ihm.Sonor;

/**
 * Created by chouaib on 30/12/16.
 */
public class SonorTic implements Command {

    private String pathMedia = "/home/chouaib/IdeaProjects/metronomeV2/src/resources/tic.wav";
    private Sonor sonor;

    public SonorTic(Sonor sonor) {
        this.sonor = sonor;
    }

    @Override
    public void execute() {
        sonor.playSound(pathMedia);
    }
}
