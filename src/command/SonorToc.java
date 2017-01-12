package command;

import ihm.Sonor;

/**
 * Created by chouaib on 30/12/16.
 */
public class SonorToc implements Command {
    private String pathMedia = "/home/chouaib/IdeaProjects/metronomeV2/src/resources/toc.wav";
    private Sonor sonor;

    public SonorToc(Sonor sonor) {
        this.sonor = sonor;
    }

    @Override
    public void execute() {
        sonor.playSound(pathMedia);
    }

}
