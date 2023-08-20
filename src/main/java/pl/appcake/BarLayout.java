package pl.appcake;

public interface BarLayout {
    void renderBar(PrettyLoadingBar prettyLoadingBar);
    void setBorderCharacters(String leftBorderCharacter, String rightBorderCharacter);
    void setCompletedStepChar(String character);
    void setUncompletedStepChar(String character);

}
