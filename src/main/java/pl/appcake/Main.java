package pl.appcake;

import pl.appcake.prettyLoadingBar.DefaultTheme;
import pl.appcake.prettyLoadingBar.PrettyLoadingBar;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // INIT VARIABLES
        int tasks = 50;


        // VARIANT 1
        // PREPARE YOUR LOADING BAR
        PrettyLoadingBar loadingBarVARIANT_1 = PrettyLoadingBar.getBuilder()
                .setTotalTaskCountToComplete(tasks)
                .setBarLength(40)
                .setLabel("Bar's label", PrettyLoadingBar.LEFT)
                .setDescription("Pretty loading bar description")
                .build();
        // USE YOUR LOADING BAR
        for (int i = 1; i <= tasks + 10; i++) {
            loadingBarVARIANT_1.updateProgress(i);
            Thread.sleep(100);
        }




        // VARIANT 2
        // COPY FROM EXISTING LOADING BAR AND ADD OWN MODIFICATIONS
        try {
            DefaultTheme newTheme = DefaultTheme.copyStyleFromExistingLoadingBar(loadingBarVARIANT_1);
            newTheme.setBarLength(10);
            newTheme.setCompletedStepChar("X");
            newTheme.setUncompletedStepChar("m");
            newTheme.setBorderCharacters("*&*","*&*");
            newTheme.addStyleToCollection("XMas");

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        // PREPARE YOUR LOADING BAR
        PrettyLoadingBar loadingBarVARIANT_2 = PrettyLoadingBar.getBuilder()
                .setStyle("XMas")
                .setTotalTaskCountToComplete(tasks)
                .build();
        // USE YOUR LOADING BAR
        for (int i = 1; i <= tasks + 10; i++) {
            loadingBarVARIANT_2.updateProgress(i);
            Thread.sleep(100);
        }


    }
}