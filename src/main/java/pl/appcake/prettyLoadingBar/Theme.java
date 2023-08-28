package pl.appcake.prettyLoadingBar;

import java.util.*;

public interface Theme extends Cloneable {
    static HashMap<String, Theme> themesContainerMap = new HashMap<String, Theme>();

    void addStyleToCollection(String nameOfTheme);

    int getBarLength();

    int getLabelPosition();

    boolean isDisplayPercentage();

    int getPercentageDisplayPosition();

    String getLeftBarBorderChar();

    String getRightBarBorderChar();

    String getCompletedStepChar();

    String getUncompletedStepChar();

    void setBarLength(int barLength);

    void setLabelPosition(int labelPosition);

    void setDisplayPercentage(boolean displayPercentage);

    void setPercentageDisplayPosition(int percentageDisplayPosition);

    void setBorderCharacters(String leftBorderCharacter, String rightBorderCharacter);

    void setCompletedStepChar(String character);

    void setUncompletedStepChar(String character);

}
