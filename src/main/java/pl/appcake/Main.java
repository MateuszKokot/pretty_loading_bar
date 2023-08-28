package pl.appcake;

import pl.appcake.prettyLoadingBar.DefaultTheme;
import pl.appcake.prettyLoadingBar.PrettyLoadingBar;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int tasks = 50;




        PrettyLoadingBar loadingBar = PrettyLoadingBar.getBuilder()
                .setTotalTaskCountToComplete(tasks)
                .setBarLength(40)
                .setDisplayPercentage(true, 1)
                .setLabel("Przytulanie kotka", 0)
                .setDescription("Pasek wskazuje czy kotek jest już Wygłaskany")
                .setBorderCharacter("[","]")
                .setCompletedCharacter("#")
                .setUncompletedCharacter("=")
                .build();

        for (int i = 1; i <= tasks + 10; i++) {

            loadingBar.updateProgress(i);
            Thread.sleep(100);
        }

        try {
            DefaultTheme newTheme = DefaultTheme.copyStyleFromExistingLoadingBar(loadingBar);
            newTheme.setCompletedStepChar("X");
            newTheme.addStyleToCollection("Iksowa");

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        PrettyLoadingBar loadingBar22 = PrettyLoadingBar.getBuilder()
                .setStyle("Iksowa")
                .setTotalTaskCountToComplete(tasks)
                .build();

        for (int i = 1; i <= tasks + 10; i++) {

            loadingBar22.updateProgress(i);
            Thread.sleep(100);
        }


    }
}