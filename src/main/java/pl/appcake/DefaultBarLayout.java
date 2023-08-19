package pl.appcake;

public class DefaultBarLayout implements BarLayout {

    // FIELDS
    private String leftBarBorderChar = CharLibrary.NOTHING ;
    private String rightBarBorderChar = CharLibrary.NOTHING ;;
    private String completedStepChar = CharLibrary.SQUARE_CONTAINING_SMALL_SQUARE;
    private String uncompletedStepChar = CharLibrary.SQUARE;

    // METHODS
    @Override
    public void renderBar(PrettyLoadingBar prettyLoadingBar) {

        int uncompletedSteps = prettyLoadingBar.getBarLength() - (int) prettyLoadingBar.getCurrentNumberOfSteps();
        int currentNumberOfSteps = (int) prettyLoadingBar.getCurrentNumberOfSteps();

        // DRAWING LEFT BAR LABEL
        if (prettyLoadingBar.getLabelPosition() == 0) System.out.print(prettyLoadingBar.getLabel() + "\t");

        // DRAWING PERCENT
        if (prettyLoadingBar.getPercentageDisplayPosition() == 0 && prettyLoadingBar.isDisplayPercentage()) {
            System.out.printf("%.0f%%\t", prettyLoadingBar.getProgressPercentage());
        }

        // DRAWING LEFT BAR BORDER
        System.out.print(leftBarBorderChar);

        // DRAWING COMPLETED STEPS
        for (int i = 0; i < currentNumberOfSteps; i++) {System.out.print(completedStepChar);}

        // DRAWING UNCOMPLETED STEPS
        for (int j = 0; j < uncompletedSteps; j++) {
            System.out.print(uncompletedStepChar);
        }

        // DRAWING RIGHT BAR BORDER
        System.out.print(rightBarBorderChar + "\t");

        // DRAWING PERCENT
        if (prettyLoadingBar.getPercentageDisplayPosition() == 1 && prettyLoadingBar.isDisplayPercentage()) {
            System.out.printf("%.0f%%\t", prettyLoadingBar.getProgressPercentage());
        }

        // DRAWING RIGHT BAR LABEL
        if (prettyLoadingBar.getLabelPosition() == 1) System.out.print(prettyLoadingBar.getLabel() + "\t");

        // DRAWING DESCRIPTION
        System.out.print(prettyLoadingBar.getDescription() + "\t");

        // BACK CURSOR TO START POSITION
        System.out.print("\r");





    }
}
