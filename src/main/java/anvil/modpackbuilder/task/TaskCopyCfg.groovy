package anvil.modpackbuilder.task

import org.gradle.api.tasks.Copy;
import org.gradle.api.tasks.TaskAction;

public class TaskCopyCfg extends Copy {

    public TaskCopyCfg() {
        setGroup("modpackbuilder");
        dependsOn("deleteOverrides");
        from("src/cfg");
        into("build/mc/overrides/config");
    }

    @TaskAction
    public void action() {

    }



}
