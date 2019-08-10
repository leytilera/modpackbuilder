package anvil.modpackbuilder.task;

import org.gradle.api.tasks.Copy;
import org.gradle.api.tasks.TaskAction;

public class TaskCopyOverrides extends Copy {

    public TaskCopyOverrides() {
        setGroup("modpackbuilder");
        dependsOn("copyCfg");
        from("src/twitch/overrides");
        into("build/mc/overrides");
    }

    @TaskAction
    public void action() {

    }

}
