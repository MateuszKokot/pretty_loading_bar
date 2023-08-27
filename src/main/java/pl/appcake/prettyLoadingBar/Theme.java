package pl.appcake.prettyLoadingBar;

import java.util.*;

public interface Theme extends Cloneable {
    static HashMap<String, Theme> themesContainerMap = new HashMap<String, Theme>();
    void addStyleToCollection(String nameOfTheme);

    String getLeftBarBorderChar();

    String getRightBarBorderChar();

    String getCompletedStepChar();

    String getUncompletedStepChar();

    void setBorderCharacters(String leftBorderCharacter, String rightBorderCharacter);

    void setCompletedStepChar(String character);

    void setUncompletedStepChar(String character);

}
