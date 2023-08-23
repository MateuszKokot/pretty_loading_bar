package pl.appcake;

import pl.appcake.prettyLoadingBar.DefaultTheme;
import pl.appcake.prettyLoadingBar.PrettyLoadingBar;
import pl.appcake.prettyLoadingBar.Theme;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int tasks = 140;



        PrettyLoadingBar loadingBar = PrettyLoadingBar.getBuilder()
                .setTotalTaskCountToComplete(tasks)
                .setBarLength(40)
                .setPercentageDisplay(true, 1)
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


    }
}