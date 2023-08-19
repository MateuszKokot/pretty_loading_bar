package pl.appcake;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int tasks = 133;


        PrettyLoadingBar loadingBar = PrettyLoadingBar.getBuilder()
                .setTotalTaskCountToComplete(tasks)
                .setBarLength(40)
                .setPercentageDisplay(true, 1)
                .setLabel("Przytulanie kotka", 0)
                .setDescription("Pasek wskazuje czy kotek jest już WYgłaskany")
                .build();

        for (int i = 1; i <= tasks + 10; i++) {

            loadingBar.updateProgress(i);
            Thread.sleep(100);
        }


    }
}