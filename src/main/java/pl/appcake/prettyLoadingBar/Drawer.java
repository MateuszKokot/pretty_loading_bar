package pl.appcake.prettyLoadingBar;

public class Drawer implements DrawerOperations {
    @Override
    public void renderBar(PrettyLoadingBar prettyLoadingBar) {

        int uncompletedSteps = prettyLoadingBar.getBarLength() - (int) prettyLoadingBar.getCurrentNumberOfSteps();
        int currentNumberOfSteps = (int) prettyLoadingBar.getCurrentNumberOfSteps();

        // DRAWING LEFT BAR LABEL
        if (prettyLoadingBar.getLabelPosition() == PrettyLoadingBar.LEFT) System.out.print(prettyLoadingBar.getLabel() + "\t");

        // DRAWING LEFT PERCENT
        if (prettyLoadingBar.getPercentageDisplayPosition() == PrettyLoadingBar.LEFT && prettyLoadingBar.isDisplayPercentage()) {
            System.out.printf("%.0f%%  \t", prettyLoadingBar.getProgressPercentage());
        }

        // DRAWING LEFT BAR BORDER
        System.out.print(prettyLoadingBar.getTheme().getLeftBarBorderChar());

        // DRAWING COMPLETED STEPS
        for (int i = 0; i < currentNumberOfSteps; i++) {System.out.print(prettyLoadingBar.getTheme().getCompletedStepChar());}

        // DRAWING UNCOMPLETED STEPS
        for (int j = 0; j < uncompletedSteps; j++) {
            System.out.print(prettyLoadingBar.getTheme().getUncompletedStepChar());
        }

        // DRAWING RIGHT BAR BORDER
        System.out.print(prettyLoadingBar.getTheme().getRightBarBorderChar() + "\t");

        // DRAWING RIGHT PERCENT
        if (prettyLoadingBar.getPercentageDisplayPosition() == PrettyLoadingBar.RIGHT && prettyLoadingBar.isDisplayPercentage()) {
            System.out.printf("%.0f%%  \t", prettyLoadingBar.getProgressPercentage());
        }

        // DRAWING RIGHT BAR LABEL
        if (prettyLoadingBar.getLabelPosition() == PrettyLoadingBar.RIGHT) System.out.print(prettyLoadingBar.getLabel() + "\t");

        // DRAWING DESCRIPTION
        System.out.print(prettyLoadingBar.getDescription() + "\t");

        // BACK CURSOR TO START POSITION
        System.out.print("\r");
    }


}
