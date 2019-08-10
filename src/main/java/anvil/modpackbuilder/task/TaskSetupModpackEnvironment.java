package anvil.modpackbuilder.task;

import org.gradle.api.tasks.TaskAction;

import java.io.File;

public class TaskSetupModpackEnvironment extends ModpackBuilderTask {

    @TaskAction
    public void action() {
        new File(getProject().getProjectDir().getPath() + "/src/twitch").mkdirs();
        new File(getProject().getProjectDir().getPath() + "/src/cfg").mkdirs();
        new File(getProject().getProjectDir().getPath() + "/src/addonscript").mkdirs();
    }

}
