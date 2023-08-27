package pl.appcake.prettyLoadingBar;

//TODO jest dzióra kiedy ktoś nie ilości kroków
public class PrettyLoadingBar {

    // DEFAULT CONFIG
    private static final int DEFAULT_LENGTH = 10;
    private static final int DEFAULT_LABEL_POSITION = 0;
    private static final String EMPTY_TEXT = "";
    private static final boolean DEFAULT_PERCENTAGE_DISPLAY = true;
    private static final int DEFAULT_PERCENTAGE_DISPLAY_POSITION = 1;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final String DEFAULT_THEME = "default";


    // FIELDS
    private final Theme theme;
    private final DrawerOperations drawer;
    private final int totalTaskCountToComplete;
    private final int barLength;
    private final double stepsPerTask;
    private double currentNumberOfSteps;
    private int labelPosition;
    private String label;
    private String description;
    boolean displayPercentage;
    int percentageDisplayPosition;
    double progressPercentage;


    //CONSTRUCTORS
    private PrettyLoadingBar(HolderForBuilder holder) {
        this.theme = holder.theme;
        this.drawer = holder.drawer;
        this.totalTaskCountToComplete = holder.totalTaskCountToComplete;
        this.barLength = holder.barLength;
        this.labelPosition = holder.labelPosition;
        this.label = holder.label;
        this.description = holder.description;
        this.displayPercentage = holder.displayPercentage;
        this.percentageDisplayPosition = holder.percentageDisplayPosition;

        stepsPerTask = this.barLength / (double) this.totalTaskCountToComplete;
    }

    //METHODS

    public void updateProgress(int completedTasks) {
        if (!(completedTasks > totalTaskCountToComplete)) {
            this.currentNumberOfSteps = completedTasks * stepsPerTask;
            this.progressPercentage = (double) completedTasks / totalTaskCountToComplete * 100;
        }
        drawer.renderBar(this);
    }

    /**
     * Method creating new instance of Builder
     *
     * @return instance of concrete Builder
     */
    public static PrettyLoadingBarBuilder getBuilder() {
        return new DefaultPrettyLoadingBarBuilder();
    }

    // GETTERS & SETTERS

    int getTotalTaskCountToComplete() {
        return totalTaskCountToComplete;
    }

    int getBarLength() {
        return barLength;
    }

    double getStepsPerTask() {
        return stepsPerTask;
    }

    double getCurrentNumberOfSteps() {
        return currentNumberOfSteps;
    }

    public int getLabelPosition() {
        return labelPosition;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDisplayPercentage() {
        return displayPercentage;
    }

    public int getPercentageDisplayPosition() {
        return percentageDisplayPosition;
    }

    public double getProgressPercentage() {
        return progressPercentage;
    }

    public Theme getTheme() {
        return theme;
    }

    // INNER CLASS & INTERFACES
    public interface PrettyLoadingBarBuilder {
        PrettyLoadingBarBuilder setTotalTaskCountToComplete(int totalTaskCountToComplete);

        PrettyLoadingBarBuilder setBarLength(int length);

        PrettyLoadingBarBuilder setUncompletedCharacter(String character);

        PrettyLoadingBarBuilder setCompletedCharacter(String character);

        PrettyLoadingBarBuilder setBorderCharacter(String leftBorderCharacter, String rightBorderCharacter);

        PrettyLoadingBarBuilder setLabel(String label);

        PrettyLoadingBarBuilder setLabel(String label, int position);

        PrettyLoadingBarBuilder setDescription(String description);

        PrettyLoadingBarBuilder setPercentageDisplay(boolean displayPercentage);

        PrettyLoadingBarBuilder setPercentageDisplay(boolean displayPercentage, int position);

        PrettyLoadingBarBuilder setStyle(String themeName);

        PrettyLoadingBar build();
    }

    private static class HolderForBuilder {
        DrawerOperations drawer = new Drawer();
        Theme theme = new DefaultTheme();
        int barLength = DEFAULT_LENGTH;
        int totalTaskCountToComplete;
        int labelPosition = DEFAULT_LABEL_POSITION;
        String label = EMPTY_TEXT;
        String description = EMPTY_TEXT;
        boolean displayPercentage = DEFAULT_PERCENTAGE_DISPLAY;
        int percentageDisplayPosition = DEFAULT_PERCENTAGE_DISPLAY_POSITION;

    }

    private static class DefaultPrettyLoadingBarBuilder extends HolderForBuilder implements PrettyLoadingBarBuilder {
        @Override
        public PrettyLoadingBarBuilder setTotalTaskCountToComplete(int totalTaskCountToComplete) {
            this.totalTaskCountToComplete = totalTaskCountToComplete;
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setBarLength(int barLength) {
            this.barLength = barLength;
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setUncompletedCharacter(String character) {
            theme.setUncompletedStepChar(character);
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setCompletedCharacter(String character) {
            theme.setCompletedStepChar(character);
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setBorderCharacter(String leftBorderCharacter, String rightBorderCharacter) {
            theme.setBorderCharacters(leftBorderCharacter, rightBorderCharacter);
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setLabel(String label) {
            this.label = label;
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setLabel(String label, int position) {
            this.label = label;
            this.labelPosition = position;
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setPercentageDisplay(boolean displayPercentage) {
            this.displayPercentage = displayPercentage;
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setPercentageDisplay(boolean displayPercentage, int position) {
            this.displayPercentage = displayPercentage;
            this.percentageDisplayPosition = position;
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setStyle(String themeName) {
            Theme defaultTheme = Theme.themesContainerMap.get(DEFAULT_THEME);
            theme = Theme.themesContainerMap.getOrDefault(themeName, defaultTheme);

            // TODO nie kopiuje wszystiego klonem bo nie wsyztko jest przechowywane w THEME. Rozważyć przeniesienie tam pól
            return this;
        }

        @Override
        public PrettyLoadingBar build() {
            return new PrettyLoadingBar(this);
        }
    }

}
