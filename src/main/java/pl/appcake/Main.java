package pl.appcake;

import pl.appcake.prettyLoadingBar.CharLibrary;
import pl.appcake.prettyLoadingBar.DefaultTheme;
import pl.appcake.prettyLoadingBar.PrettyLoadingBar;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // INIT VARIABLES
        int tasks = 50;
        // TODO ZABEZPIECZ BRAK WPROWADZENIA ILOŚCI TASKÓ DO WYKONANIA W BUILDERZE


        // VARIANT 1
        // PREPARE YOUR LOADING BAR
        PrettyLoadingBar loadingBarVARIANT_1 = PrettyLoadingBar.getBuilder()
                .setTotalTaskCountToComplete(tasks)
                .setBarLength(40)
                .setLabel("Bar's label", PrettyLoadingBar.LEFT)
                .setDescription("Pretty loading bar description")
                .setCompletedCharacter(CharLibrary.SQUARE_FILLED)
                .setUncompletedCharacter(CharLibrary.SQUARE_EMPTY)
                .setBorderCharacter("","")
                .build();
        // USE YOUR LOADING BAR
        System.out.println("VARIANT 1");
        for (int i = 1; i <= tasks + 10; i++) {
            loadingBarVARIANT_1.updateProgress(i);
            Thread.sleep(100);
        }
        System.out.println("\n\n");




        // VARIANT 2
        // COPY FROM EXISTING LOADING BAR AND ADD OWN MODIFICATIONS
        try {
            DefaultTheme newTheme = DefaultTheme.copyStyleFromExistingLoadingBar(loadingBarVARIANT_1);
            newTheme.setBarLength(20);
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
                .setLabel("XMAS !")
                .build();
        // USE YOUR LOADING BAR
        System.out.println("VARIANT 2");
        for (int i = 1; i <= tasks + 10; i++) {
            loadingBarVARIANT_2.updateProgress(i);
            Thread.sleep(100);
        }
        System.out.println("\n\n");



        // VARIANT 3
        // USE DEFAULT THEME
        PrettyLoadingBar loadingBarVARIANT_3 = PrettyLoadingBar.getBuilder()
                .setTotalTaskCountToComplete(tasks)
                .build();
        // USE YOUR LOADING BAR
        System.out.println("VARIANT 3");
        for (int i = 1; i <= tasks + 10; i++) {
            loadingBarVARIANT_3.updateProgress(i);
            Thread.sleep(100);
        }
        System.out.println("\n\n");
    }
}