package pl.appcake.prettyLoadingBar;

public interface Theme {
    void copyStyleFromLoadingBar(PrettyLoadingBar loadingBar);

    void addStyleToCollection(String nameOfTheme, Theme theme);

    String getLeftBarBorderChar();

    String getRightBarBorderChar();

    String getCompletedStepChar();

    String getUncompletedStepChar();

    void setBorderCharacters(String leftBorderCharacter, String rightBorderCharacter);

    void setCompletedStepChar(String character);

    void setUncompletedStepChar(String character);

}
