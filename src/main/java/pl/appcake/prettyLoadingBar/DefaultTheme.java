package pl.appcake.prettyLoadingBar;

import java.util.HashMap;
import java.util.Map;

public class DefaultTheme implements Theme {
    // FIELDS
    private int barLength;
    private int labelPosition;
    private boolean displayPercentage;
    private int percentageDisplayPosition;
    private String leftBarBorderChar;
    private String rightBarBorderChar;
    private String completedStepChar;
    private String uncompletedStepChar;
//    static Map<String, DefaultTheme> themesContainerMap = new HashMap<String, DefaultTheme>() {{
//        put("default", new DefaultTheme(10,PrettyLoadingBar.LEFT, true, PrettyLoadingBar.RIGHT, "<", ">", "|","_"));
//        put("classic", new DefaultTheme(10,PrettyLoadingBar.LEFT, true, PrettyLoadingBar.RIGHT, "[", "]", "#","-"));
//    }};

    static {
        themesContainerMap.put("default", new DefaultTheme(10,PrettyLoadingBar.LEFT, true, PrettyLoadingBar.RIGHT, "<", ">", "|","_"));
        themesContainerMap.put("classic", new DefaultTheme(10,PrettyLoadingBar.LEFT, true, PrettyLoadingBar.RIGHT, "[", "]", "#","-"));
    }

    // CONSTRUCTORS
    DefaultTheme() {
    }

    public DefaultTheme(int barLength, int labelPosition, boolean displayPercentage,
                        int percentageDisplayPosition, String leftBarBorderChar, String rightBarBorderChar,
                        String completedStepChar, String uncompletedStepChar) {
        this.barLength = barLength;
        this.labelPosition = labelPosition;
        this.displayPercentage = displayPercentage;
        this.percentageDisplayPosition = percentageDisplayPosition;
        this.leftBarBorderChar = leftBarBorderChar;
        this.rightBarBorderChar = rightBarBorderChar;
        this.completedStepChar = completedStepChar;
        this.uncompletedStepChar = uncompletedStepChar;
    }

    // METHODS


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public static DefaultTheme copyStyleFromLoadingBar(PrettyLoadingBar loadingBar) throws CloneNotSupportedException {
        DefaultTheme theme = (DefaultTheme) loadingBar.getTheme();
        return (DefaultTheme) theme.clone();
    }

    @Override
    public void addStyleToCollection(String nameOfTheme) {
        themesContainerMap.put(nameOfTheme, this);
    }


    // GETTERS & SETTERS
    public int getBarLength() {
        return barLength;
    }

    public int getLabelPosition() {
        return labelPosition;
    }

    public boolean isDisplayPercentage() {
        return displayPercentage;
    }

    public int getPercentageDisplayPosition() {
        return percentageDisplayPosition;
    }


    @Override
    public String getLeftBarBorderChar() {
        return leftBarBorderChar;
    }

    @Override
    public String getRightBarBorderChar() {
        return rightBarBorderChar;
    }

    @Override
    public String getCompletedStepChar() {
        return completedStepChar;
    }

    @Override
    public String getUncompletedStepChar() {
        return uncompletedStepChar;
    }

    public void setBarLength(int barLength) {
        this.barLength = barLength;
    }

    public void setLabelPosition(int labelPosition) {
        this.labelPosition = labelPosition;
    }

    public void setDisplayPercentage(boolean displayPercentage) {
        this.displayPercentage = displayPercentage;
    }

    public void setPercentageDisplayPosition(int percentageDisplayPosition) {
        this.percentageDisplayPosition = percentageDisplayPosition;
    }

    @Override
    public void setBorderCharacters(String leftBorderCharacter, String rightBorderCharacter) {
        this.leftBarBorderChar = leftBorderCharacter;
        this.rightBarBorderChar = rightBorderCharacter;
    }

    @Override
    public void setCompletedStepChar(String character) {
        this.completedStepChar = character;
    }

    @Override
    public void setUncompletedStepChar(String character) {
        this.uncompletedStepChar = character;
    }

}
