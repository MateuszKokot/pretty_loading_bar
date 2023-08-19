package pl.appcake;

//TODO jest dzióra kiedy ktoś nie ilości kroków
public class PrettyLoadingBar {

    // DEFAULT CONFIG
    private static final int DEFAULT_LENGTH = 10;
    private static final int DEFAULT_LABEL_POSITION = 0;
    private static final String EMPTY_TEXT = "";
    private static final boolean DEFAULT_PERCENTAGE_DISPLAY = true;
    private static final int DEFAULT_PERCENTAGE_DISPLAY_POSITION = 1;

    // FIELDS
    private final BarLayout barLayout;
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
        barLayout = new DefaultBarLayout();

        this.totalTaskCountToComplete = holder.totalTaskCountToComplete;
        this.barLength = holder.barLength;
        this.labelPosition = holder.labelPosition;
        this.label = holder.label;
        this.description = holder.description;
        this.displayPercentage = holder.displayPercentage;
        this.percentageDisplayPosition = holder.percentageDisplayPosition;


        stepsPerTask = this.barLength / (double) this.totalTaskCountToComplete;
        init();
    }

    //METHODS

    private void init() {

    }

    public void updateProgress(int completedTasks) {
        if (!(completedTasks > totalTaskCountToComplete)) {
            this.currentNumberOfSteps = completedTasks * stepsPerTask;
            this.progressPercentage = (double) completedTasks / totalTaskCountToComplete * 100;
        }
        barLayout.renderBar(this);
        // TODO DODAJ WYLICZANIE PROCENTOWEGO WSKAŹNIKA
    }

    /**
     * Method creating new instance of Builder
     *
     * @return instance of concrete Builder
     */
    static PrettyLoadingBarBuilder getBuilder() {
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

    // INNER CLASS & INTERFACES
    interface PrettyLoadingBarBuilder {
        /**
         * This method sets how many steps loading bar pass
         *
         * @param totalTaskCountToComplete provides how many steps loading bar pass
         * @return this
         */
        PrettyLoadingBarBuilder setTotalTaskCountToComplete(int totalTaskCountToComplete);
        PrettyLoadingBarBuilder setBarLength(int length);
        PrettyLoadingBarBuilder setUndoneCharacter(String character);
        PrettyLoadingBarBuilder setDoneCharacter(String character);
        PrettyLoadingBarBuilder setBorderCharacter(String character);
        PrettyLoadingBarBuilder setLabel(String label);

        /**
         * @param label
         * @param position defines position of label next to bar. 0=left / 1=right
         * @return
         */
        PrettyLoadingBarBuilder setLabel(String label, int position);
        PrettyLoadingBarBuilder setDescription(String description);
        PrettyLoadingBarBuilder setPercentageDisplay(boolean displayPercentage);
        PrettyLoadingBarBuilder setPercentageDisplay(boolean displayPercentage, int position);
        PrettyLoadingBarBuilder setStyle(String character);
        /**
         * @return built PrettyLoadingBar
         */
        PrettyLoadingBar build();
    }

    private static class HolderForBuilder {
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
        public PrettyLoadingBarBuilder setUndoneCharacter(String character) {
            return null;
        }

        @Override
        public PrettyLoadingBarBuilder setDoneCharacter(String character) {
            return null;
        }

        @Override
        public PrettyLoadingBarBuilder setBorderCharacter(String character) {
            return null;
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
        public PrettyLoadingBarBuilder setStyle(String character) {
            return null;
        }

        @Override
        public PrettyLoadingBar build() {
            return new PrettyLoadingBar(this);
        }
    }

}
