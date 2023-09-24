package pl.appcake.prettyLoadingBar;

//TODO jest bug kiedy ktoś nie ilości kroków
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
    private String label;
    private String description;
    // COUNTED FIELDS
    private final double stepsPerTask;
    private double currentNumberOfSteps;
    double progressPercentage;
    int completedTasks;


    //CONSTRUCTORS
    private PrettyLoadingBar(HolderForBuilder holder) {
        this.theme = holder.theme;
        this.drawer = holder.drawer;
        this.totalTaskCountToComplete = holder.totalTaskCountToComplete;
        this.label = holder.label;
        this.description = holder.description;
        stepsPerTask = theme.getBarLength() / (double) this.totalTaskCountToComplete;
    }

    //METHODS

    public void updateProgress(int completedTasks) {
        this.completedTasks = completedTasks;
        if (!(completedTasks > totalTaskCountToComplete)) {
            this.currentNumberOfSteps = completedTasks * stepsPerTask;
            this.progressPercentage = (double) completedTasks / totalTaskCountToComplete * 100;
        }
        drawer.renderBar(this);
    }

    public static PrettyLoadingBarBuilder getBuilder() {
        return new DefaultPrettyLoadingBarBuilder();
    }

    // GETTERS & SETTERS

    int getTotalTaskCountToComplete() {
        return totalTaskCountToComplete;
    }

    int getBarLength() {
        return theme.getBarLength();
    }

    double getStepsPerTask() {
        return stepsPerTask;
    }

    double getCurrentNumberOfSteps() {
        return currentNumberOfSteps;
    }

    public int getLabelPosition() {
        return theme.getLabelPosition();
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDisplayPercentage() {
        return theme.isDisplayPercentage();
    }

    public int getPercentageDisplayPosition() {
        return theme.getPercentageDisplayPosition();
    }

    public double getProgressPercentage() {
        return progressPercentage;
    }

    public Theme getTheme() {
        return theme;
    }

    public int getCompletedTasks() {
        return completedTasks;
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

        PrettyLoadingBarBuilder setDisplayPercentage(boolean displayPercentage);

        PrettyLoadingBarBuilder setDisplayPercentage(boolean displayPercentage, int position);

        PrettyLoadingBarBuilder setStyle(String themeName);

        PrettyLoadingBar build();
    }

    private static class HolderForBuilder {
        DrawerOperations drawer = new Drawer();
        Theme theme = new DefaultTheme();
        int totalTaskCountToComplete;
        String label = EMPTY_TEXT;
        String description = EMPTY_TEXT;


    }

    private static class DefaultPrettyLoadingBarBuilder extends HolderForBuilder implements PrettyLoadingBarBuilder {
        @Override
        public PrettyLoadingBarBuilder setTotalTaskCountToComplete(int totalTaskCountToComplete) {
            this.totalTaskCountToComplete = totalTaskCountToComplete;
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setBarLength(int barLength) {
            this.theme.setBarLength(barLength);
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setUncompletedCharacter(String character) {
            this.theme.setUncompletedStepChar(character);
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setCompletedCharacter(String character) {
            this.theme.setCompletedStepChar(character);
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setBorderCharacter(String leftBorderCharacter, String rightBorderCharacter) {
            this.theme.setBorderCharacters(leftBorderCharacter, rightBorderCharacter);
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
            this.theme.setLabelPosition(position);
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setDisplayPercentage(boolean displayPercentage) {
            theme.setDisplayPercentage(displayPercentage);
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setDisplayPercentage(boolean displayPercentage, int position) {
            this.theme.setDisplayPercentage(displayPercentage);
            this.theme.setPercentageDisplayPosition(position);
            return this;
        }

        @Override
        public PrettyLoadingBarBuilder setStyle(String themeName) {
            Theme defaultTheme = Theme.themesContainerMap.get(DEFAULT_THEME);
            this.theme = Theme.themesContainerMap.getOrDefault(themeName, defaultTheme);
            return this;
        }

        @Override
        public PrettyLoadingBar build() {
            return new PrettyLoadingBar(this);
        }
    }

}
